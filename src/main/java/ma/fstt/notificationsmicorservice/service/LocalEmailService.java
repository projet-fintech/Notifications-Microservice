package ma.fstt.notificationsmicorservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service

public class LocalEmailService implements EmailSender {

    @Autowired
    private EmailService emailService;

    @Override
    public void sendEmail(String to, String subject, String content) {
        try {
            String actionUrl = "https://example.com/action"; // URL d'action (ex: lien vers une page)
            String actionText = "Cliquez ici"; // Texte du bouton d'action

            emailService.sendHtmlEmail(to, subject, content, actionUrl, actionText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
