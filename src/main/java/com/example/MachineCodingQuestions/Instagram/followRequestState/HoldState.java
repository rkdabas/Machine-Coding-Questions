package com.example.MachineCodingQuestions.Instagram.followRequestState;

import com.example.MachineCodingQuestions.Instagram.dto.FollowRequest;
import com.example.MachineCodingQuestions.Instagram.services.EmailNotificationServiceImpl;

public class HoldState extends State {
    public static HoldState holdState=new HoldState();

    public HoldState(){
        super(new EmailNotificationServiceImpl());
    }

    @Override
    public void notifyUser(FollowRequest followRequest){
        notificationService.sendNotification("You have a friend request: ",followRequest.getSender());
    }
}
