package com.example.MachineCodingQuestions.Instagram.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String description;
    private Profile createdBy;
    private List<Comment>comments;
    private List<Like>likes;
    private LocalDateTime createdAt;

    public Post(String description,Profile createdBy){
        this.createdBy=createdBy;
        this.description=description;
        comments=new ArrayList<>();
        likes=new ArrayList<>();
        createdAt=LocalDateTime.now();
    }
}
