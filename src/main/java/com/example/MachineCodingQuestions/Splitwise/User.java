package com.example.MachineCodingQuestions.Splitwise;

//import com.example.MachineCodingQuestions.Splitwise.Notification;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private UUID userId;
    private String name;
    private String email;
    private List<Notification> notifications;

    public User(String name, String email) {
        this.userId = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.notifications = new ArrayList<>();
    }

    public UUID getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public void notify(Notification notification){
        notifications.add(notification);
        System.out.println("Notification for "+name+": "+notification.getMessage());
    }
}
