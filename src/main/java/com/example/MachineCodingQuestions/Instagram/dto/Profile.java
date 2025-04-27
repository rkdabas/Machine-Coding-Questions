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
public class Profile {
    private String id;
    private String email;
    private String password;
    private List<Profile>followers;
    private List<Profile>followings;
    private Timeline timeline;
    private boolean isCelebrity;
    private LocalDateTime lastSeen;

    public Profile(String id,String email,String password){
        this.email=email;
        this.password=password;
        this.id=id;
        followers=new ArrayList<>();
        followings=new ArrayList<>();
        timeline=new Timeline();
        isCelebrity=false;
    }
}
