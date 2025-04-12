package com.example.MachineCodingQuestions.Splitwise;

import java.util.UUID;

public class Notification {
    private UUID notifId;
    private String message;
    private boolean isRead;

    public Notification(String message){
        this.notifId=UUID.randomUUID();
        this.message=message;
        this.isRead=false;
    }

    public String getMessage(){
        return message;
    }
    public void markAsRead() {
        isRead = true;
    }
}
