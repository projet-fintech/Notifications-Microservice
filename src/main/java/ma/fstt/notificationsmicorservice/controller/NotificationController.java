package ma.fstt.notificationsmicorservice.controller;


import ma.fstt.notificationsmicorservice.dto.NotificationRequest;
import ma.fstt.notificationsmicorservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public String sendNotification(@RequestBody NotificationRequest request) {
        notificationService.sendNotification(
                request.getType(),
                request.getRecipientEmail(),
                request.getSubject(),
                request.getContent()
        );
        return "Notification sent!";
    }
}