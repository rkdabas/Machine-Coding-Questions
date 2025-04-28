package com.example.MachineCodingQuestions.Instagram.services;

import com.example.MachineCodingQuestions.Instagram.dto.FollowRequest;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;
import com.example.MachineCodingQuestions.Instagram.followRequestState.AcceptedState;
import com.example.MachineCodingQuestions.Instagram.followRequestState.DeclineState;
import com.example.MachineCodingQuestions.Instagram.interfaces.FollowRequestService;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class FollowRequestServiceImpl implements FollowRequestService {
    ReentrantLock lock=new ReentrantLock();

    @Override
    public void createFollowRequest(Profile sender, Profile receiver) {
        if(checkIfPresent(sender,receiver)){
            throw new Exception("follow request already present");
        }
        lock.lock();
        if(checkIfPresent(sender,receiver)){
            FollowRequest followRequest=new FollowRequest(sender,receiver);
            receiver.getFollowRequests().add(followRequest);
            followRequest.sendNotification();
        }
        lock.unlock();
    }

    @Override
    public List<FollowRequest> fetchAllRequest(Profile profile) {
        return profile.getFollowRequests();
    }

    @Override
    public void acceptFollowRequest(FollowRequest followRequest) {
        followRequest.setFollowRequestState(new AcceptedState());
        followRequest.sendNotification();
        removeFollowRequest(followRequest);
        followRequest.getReceiver().getFollowers().add(followRequest.getSender());
    }

    @Override
    public void rejectFollowRequest(FollowRequest followRequest) {
        followRequest.setFollowRequestState(new DeclineState());
        followRequest.sendNotification();
        removeFollowRequest(followRequest);
    }

    private boolean checkIfPresent(Profile sender, Profile receiver){
        List<FollowRequest>followRequests=receiver.getFollowRequests();
        return followRequests.stream().parallel().filter(followRequest -> followRequest.getSender().equals(sender)).findFirst().isPresent();
    }

    private void removeFollowRequest(FollowRequest followRequest){
        followRequest.getReceiver().getFollowRequests().remove(followRequest);
    }
}
