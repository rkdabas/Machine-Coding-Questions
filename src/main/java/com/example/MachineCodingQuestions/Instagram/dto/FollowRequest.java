package com.example.MachineCodingQuestions.Instagram.dto;

import com.example.MachineCodingQuestions.Instagram.followRequestState.HoldState;
import com.example.MachineCodingQuestions.Instagram.followRequestState.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowRequest {
    private Profile sender;
    private Profile receiver;
    private State followRequestState;

    public FollowRequest(Profile sender,Profile receiver){
        this.sender=sender;
        this.receiver=receiver;
        followRequestState=HoldState.holdState;
    }

    public void sendNotification(){
        followRequestState.notifyUser(this);
    }
    
    @Override
    public String toString() {
        return "FollowRequest{" +
                "sender=" + sender.getId() +
                ", receiver=" + receiver.getId() +
                ", state=" + (followRequestState != null ? followRequestState.getClass().getSimpleName() : "null") +
                '}';
    }
}
