package com.example.MachineCodingQuestions.Instagram.followRequestState;

//using state design pattern

import com.example.MachineCodingQuestions.Instagram.dto.FollowRequest;
import com.example.MachineCodingQuestions.Instagram.interfaces.NotificationService;

public abstract class State {
    protected NotificationService notificationService;

    public State(NotificationService notificationService){
        this.notificationService=notificationService;
    }

    public abstract void notifyUser(FollowRequest followRequest);

}
