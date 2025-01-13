package ma.fstt.notificationsmicorservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendHtmlEmail(String to, String subject, String content, String actionUrl, String actionText) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        // Préparer les données pour le template
        Context context = new Context();
        context.setVariable("subject", subject);
        context.setVariable("content", content);
        context.setVariable("actionUrl", actionUrl);
        context.setVariable("actionText", actionText);

        // Générer le contenu HTML à partir du template
        String htmlContent = templateEngine.process("email-template", context);

        // Configurer l'email
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true); // true pour indiquer que le contenu est HTML

        // Envoyer l'email
        mailSender.send(message);
    }
}