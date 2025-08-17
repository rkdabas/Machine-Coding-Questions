package com.example.MachineCodingQuestions.SnakeLadder;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class Dice {
    int min=1;
    int max=6;
    int noOfDice;

    Dice(int noOfDice){
        this.noOfDice=noOfDice;
    }

    public int rollDice(){
        int diceNumber = ThreadLocalRandom.current().nextInt(1,6);
        return diceNumber;
    }
}
