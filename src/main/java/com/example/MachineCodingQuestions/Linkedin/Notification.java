package com.example.MachineCodingQuestions.Linkedin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private String notificationId;
    private User user;
    private NotificationType type;
    private String context;
    private Timestamp timestamp;
}
