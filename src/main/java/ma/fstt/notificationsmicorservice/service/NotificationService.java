package ma.fstt.notificationsmicorservice.service;

import ma.fstt.notificationsmicorservice.entity.Notification;
import ma.fstt.notificationsmicorservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private EmailSender emailSender;

    public void sendNotification(String type, String recipientEmail, String subject, String content) {
        // Enregistrer la notification dans la base de données
        Notification notification = new Notification();
        notification.setType(type);
        notification.setRecipientEmail(recipientEmail);
        notification.setSubject(subject);
        notification.setContent(content);
        notification.setStatus("PENDING");
        notification.setCreatedAt(LocalDateTime.now());
        notificationRepository.save(notification);

        // Envoyer l'email
        try {
            emailSender.sendEmail(recipientEmail, subject, content);
            notification.setStatus("SENT");
            notification.setSentAt(LocalDateTime.now());
        } catch (Exception e) {
            notification.setStatus("FAILED");
        }

        notificationRepository.save(notification);
    }
}