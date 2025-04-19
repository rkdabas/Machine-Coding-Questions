package com.example.MachineCodingQuestions.Linkedin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]){
        LinkedinService linkedinService=LinkedinService.getInstance();

//         user registration
        User user1=new User("1","donut","donut@gmail.com","123456",new Profile(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2=new User("2","simba","simba@gmail.com","123",new Profile(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        linkedinService.registerUser(user1);
        linkedinService.registerUser(user2);

//        user login
        User loggedInUser=linkedinService.loginUser("donut@gmail.com","123456");
        if(loggedInUser!=null){
            System.out.println("user logged in: "+loggedInUser.getName());
        }
        else{
            System.out.println("invalid email or passsword");
        }

//        update user details
        Profile profile=new Profile();
        profile.setHeadline("developer");
        profile.setSummary("Debugging the debugger");
        loggedInUser.setProfile(profile);
        linkedinService.updateProfile(loggedInUser);

//        send connection request
        linkedinService.sendConnectionRequest(user1,user2);

//        accept connnection request
        linkedinService.acceptConnectionRequest(user2,user1);

//        post a job listing
        JobPosting job=new JobPosting("1","engineer","seeking passionate developers", Arrays.asList("Java","C++"),"Noida",new Timestamp(System.currentTimeMillis()));
        linkedinService.postJobListing(job);

//        search for users
        List<User>searchResults=linkedinService.searchUsers("Donut");
        System.out.println("User Search results: ");
        for(User user:searchResults){
            System.out.println("Name "+user.getName());
            System.out.println();
        }

//        search for job posting
        List<JobPosting>jobs=linkedinService.searchJobPostings("developers");
        System.out.println("Job posting results: ");
        for(JobPosting posting:jobs){
            System.out.println("Searched Job title: "+posting.getTitle());
            System.out.println();
        }

//        send a message
        linkedinService.sendMessage(user1,user2,"hi");

//        get notification
        List<Notification>notifications=linkedinService.getNotifications(user1.getUserId());
        System.out.println("Notifications: ");
        for(Notification notification:notifications){
            System.out.println("Notification type is: "+notification.getType());
            System.out.println();
        }


    }
}
