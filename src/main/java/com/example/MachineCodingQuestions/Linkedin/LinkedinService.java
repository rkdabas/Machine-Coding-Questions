package com.example.MachineCodingQuestions.Linkedin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedinService {
    private static LinkedinService instance;
    private Map<String,User> users;
    private Map<String,JobPosting>jobPostings;
    private Map<String,List<Notification>>notifications;

    public LinkedinService(){
        users=new ConcurrentHashMap<>();
        jobPostings=new ConcurrentHashMap<>();
        notifications=new ConcurrentHashMap<>();
    }

    public static synchronized LinkedinService getInstance(){
        if(instance==null){
            instance=new LinkedinService();
        }
        return instance;
    }

    public void registerUser(User user){
        users.put(String.valueOf(user.getUserId()),user);
    }

    public User loginUser(String email,String password){
        for(User user:users.values()){
            if(user.getEmail()==email && user.getPassword()==password){
                return user;
            }
        }
        return null;
    }

    public void updateProfile(User user){
        users.put(String.valueOf(user.getUserId()),user);
    }


    public void sendConnectionRequest(User sender,User receiver){
        Connection connection=new Connection(sender,new Timestamp(System.currentTimeMillis()));
        receiver.getConnections().add(connection);
        Notification notification=new Notification(generateNotificationId(),receiver,NotificationType.CONNECTION_REQUEST,"new connection request from "+sender.getName(),new Timestamp(System.currentTimeMillis()));
        addNotification(String.valueOf(receiver.getUserId()),notification);
    }

    public void acceptConnectionRequest(User receiver,User sender){
        for(Connection connection: receiver.getConnections()){
            if(connection.getUser().equals(sender)){
                receiver.getConnections().add(new Connection(sender,new Timestamp(System.currentTimeMillis())));
                break;
            }
        }
    }

    public List<User>searchUsers(String keyword){
        List<User>result=new ArrayList<>();
        for(User user:users.values()){
            if(user.getName().contains(keyword)){
                result.add(user);
            }
        }
        return result;
    }

    public void postJobListing(JobPosting job){
        jobPostings.put(job.getId(),job);
        for(User user:users.values()){
            Notification notification=new Notification(generateNotificationId(),user,NotificationType.JOB_POSTING,"new job posting "+job.getTitle(),new Timestamp(System.currentTimeMillis()));
            addNotification(String.valueOf(user.getUserId()),notification);
        }
    }

    public List<JobPosting> searchJobPostings(String keyword){
        List<JobPosting>results=new ArrayList<>();
        for(JobPosting jobPosting:jobPostings.values()){
            if(jobPosting.getTitle().contains(keyword) || jobPosting.getDescription().contains(keyword)){
                results.add(jobPosting);
            }
        }
        return results;
    }

    public void sendMessage(User sender,User receiver,String content){
        Message message=new Message(generateMessageId(),sender,receiver,new Timestamp(System.currentTimeMillis()),content);
        receiver.getInbox().add(message);
        sender.getSentMessages().add(message);
        Notification notification=new Notification(generateNotificationId(),receiver,NotificationType.MESSAGE,"new message from "+sender.getName(),new Timestamp(System.currentTimeMillis()));
        addNotification(String.valueOf(receiver.getUserId()),notification);
    }

    public void addNotification(String userId,Notification notification){
        notifications.computeIfAbsent(userId, k -> new CopyOnWriteArrayList<>()).add(notification);
    }
    public List<Notification>getNotifications(String userId){
        return notifications.getOrDefault(userId,new ArrayList<>());
    }


    public String generateNotificationId(){
        return UUID.randomUUID().toString();
    }
    public String generateMessageId(){
        return UUID.randomUUID().toString();
    }
}
