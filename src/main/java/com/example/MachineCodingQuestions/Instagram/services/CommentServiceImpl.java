package com.example.MachineCodingQuestions.Instagram.services;

import com.example.MachineCodingQuestions.Instagram.dto.Comment;
import com.example.MachineCodingQuestions.Instagram.dto.Post;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;
import com.example.MachineCodingQuestions.Instagram.interfaces.CommentService;

public class CommentServiceImpl implements CommentService {
    @Override
    public void createCommentOnPost(String description, Profile createdBy, Post post) {
        Comment comment=new Comment(description,createdBy);
        post.getComments().add(comment);
    }

    @Override
    public void createCommentOnComment(String description, Profile createdBy, Comment comment) {
        Comment comment1=new Comment(description,createdBy);
        comment.getComments().add(comment1);
    }
}
