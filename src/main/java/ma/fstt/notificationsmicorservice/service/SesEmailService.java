package ma.fstt.notificationsmicorservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class SesEmailService implements EmailSender {

    @Autowired
    private EmailService emailService;

    @Value("${aws.ses.fromEmail}") // Définir dans application-prod.properties
    private String fromEmail;

    @Override
    public void sendEmail(String to, String subject, String content) {
        try {
            String actionUrl = "https://example.com/action"; // URL d'action (ex: lien vers une page)
            String actionText = "Cliquez ici"; // Texte du bouton d'action

            emailService.sendHtmlEmail(to, subject, content, actionUrl, actionText);
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer l'erreur (ex: journaliser l'erreur)
        }
    }
}