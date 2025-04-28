package com.example.MachineCodingQuestions.Instagram.services;

import com.example.MachineCodingQuestions.Instagram.dto.Comment;
import com.example.MachineCodingQuestions.Instagram.dto.Like;
import com.example.MachineCodingQuestions.Instagram.dto.Post;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;
import com.example.MachineCodingQuestions.Instagram.interfaces.LikeService;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class LikeServiceImpl implements LikeService {
    ReentrantLock lock=new ReentrantLock();

    @Override
    public void likeOnPost(Post post, Profile createdBy) {
        if(!checkIfPresent(post,createdBy)){
            lock.lock();
            if(!checkIfPresent(post,createdBy)){
                Like like=new Like(createdBy);
                post.getLikes().add(like);
            }
            lock.unlock();
        }
    }

    @Override
    public void likeOnComment(Comment comment, Profile createdBy) {
        if(!checkIfCommentPresent(comment,createdBy)){
            lock.lock();
            if(!checkIfCommentPresent(comment,createdBy)){
                Like like=new Like(createdBy);
                comment.getLikes().add(like);
            }
            lock.unlock();
        }
    }

    @Override
    public void unLikeOnComment(Comment comment, Profile createdBy) {
        if(checkIfCommentPresent(comment,createdBy)){
            lock.lock();
            if(checkIfCommentPresent(comment,createdBy)){
                Comment comment2= (Comment) comment.getLikes().stream().filter(like -> like.getProfile().equals(createdBy)).collect(Collectors.toList());
                comment.getLikes().remove(comment2);
            }
            lock.unlock();
        }
    }

    @Override
    public void unLikeOnPost(Post post, Profile createdBy) {
        if(checkIfPresent(post,createdBy)){
            lock.lock();
            if(checkIfPresent(post,createdBy)){
                Like like2= (Like) post.getLikes().stream().filter(like -> like.getProfile().equals(createdBy)).collect(Collectors.toList());
                post.getLikes().remove(like2);
            }
            lock.unlock();
        }
    }

    private boolean checkIfPresent(Post post,Profile profile){
        List<Like>likes=post.getLikes();
        return likes.stream().parallel().filter(like -> like.getProfile().equals(profile)).findFirst().isPresent();
    }
    private boolean checkIfCommentPresent(Comment comment,Profile profile){
        List<Like>likes=comment.getLikes();
        return likes.stream().parallel().filter(like -> like.getProfile().equals(profile)).findFirst().isPresent();
    }
}
