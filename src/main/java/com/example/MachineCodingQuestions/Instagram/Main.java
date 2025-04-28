package com.example.MachineCodingQuestions.Instagram;

import com.example.MachineCodingQuestions.Instagram.dto.FollowRequest;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;
import com.example.MachineCodingQuestions.Instagram.interfaces.FollowRequestService;
import com.example.MachineCodingQuestions.Instagram.interfaces.PostService;
import com.example.MachineCodingQuestions.Instagram.interfaces.TimelineService;
import com.example.MachineCodingQuestions.Instagram.services.FollowRequestServiceImpl;
import com.example.MachineCodingQuestions.Instagram.services.PostServiceImpl;
import com.example.MachineCodingQuestions.Instagram.services.TimelineServiceImpl;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String args[]){
        Profile f1=new Profile("f1","f1@gmail.com","f1Pass");
        Profile f2=new Profile("f2","f2@gmail.com","f2Pass");


        FollowRequestService followRequestService=new FollowRequestServiceImpl();
        try{
            followRequestService.createFollowRequest(f1,f2);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

        System.out.println("Follow requests for f2: "+followRequestService.fetchAllRequest(f2));
        followRequestService.acceptFollowRequest(followRequestService.fetchAllRequest(f2).get(0));
        System.out.println("Follow requests: "+followRequestService.fetchAllRequest(f2));

        System.out.println("followers of f2: "+f2.getFollowers());

        PostService postService=new PostServiceImpl();
        postService.createPost(f2,"first post of f2");
        System.out.println("posts for f2: "+f2.getPosts());


        TimelineService timelineService=new TimelineServiceImpl();
        System.out.println("Timeline of f1: "+timelineService.fetchTimeline(f1));
    }
}
