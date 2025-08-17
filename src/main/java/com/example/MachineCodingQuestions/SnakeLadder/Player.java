package com.example.MachineCodingQuestions.SnakeLadder;

import lombok.Data;

@Data
public class Player {
    String id;
    int position;

    public Player(String id, int position){
        this.id=id;
        this.position=position;
    }
}
