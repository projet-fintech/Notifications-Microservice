package ma.fstt.notificationsmicorservice.service;

public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
