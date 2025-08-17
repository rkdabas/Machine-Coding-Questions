package com.example.MachineCodingQuestions.SnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int size,int noOfSnakes,int noOfLadders){
        initializeCells(size);
        addSnakeAndLadder(cells, noOfLadders, noOfSnakes);
    }

    public void initializeCells(int size){
        cells = new Cell[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cells[i][j]=new Cell();
            }
        }
    }

    public void addSnakeAndLadder(Cell[][] cells, int ladders, int snakes){
        while(snakes>0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);;

            if(snakeTail>=snakeHead) continue;

            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump=snakeObj;
            snakes--;
        }

        while(ladders>0){
            int ladderHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);;
            int ladderTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);;

            if(ladderHead>=ladderTail) continue;

            Jump ladderObj = new Jump();
            ladderObj.start = ladderHead;
            ladderObj.end = ladderTail;

            Cell cell = getCell(ladderHead);
            cell.jump=ladderObj;
            ladders--;
        }
    }

    Cell getCell(int playerPosition){
        int boardRow = playerPosition/cells.length;
        int boardCol = playerPosition%cells.length;
        return cells[boardRow][boardCol];
    }
}
