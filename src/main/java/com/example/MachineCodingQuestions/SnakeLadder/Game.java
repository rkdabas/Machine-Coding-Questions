package com.example.MachineCodingQuestions.SnakeLadder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players=new LinkedList<>();
    Player winner;

    public Game(){
        initializeGame();
    }

    public void initializeGame(){
        board = new Board(10,5,5);
        dice = new Dice(1);
        addPlayers();
        winner=null;
    }

    public void addPlayers(){
        Player player1 = new Player("p1",0);
        players.add(player1);
        Player player2 = new Player("p2",0);
        players.add(player2);
    }
    public void startGame(){
        while(winner==null){
//            check whose turn it is.
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is: "+playerTurn.id+" current position is: "+playerTurn.position);

//            roll the dice
            int diceNumbers = dice.rollDice();

//            get the new position
            int playerNewPosition = playerTurn.position + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.position = playerNewPosition;

            System.out.println("player turn is: "+playerTurn.id+" new positon is: "+playerNewPosition);

//            check for the winning condition
            if(playerNewPosition>=board.cells.length*board.cells.length-1){
                winner = playerTurn;
            }
        }
        System.out.println("Winner is: "+winner);
    }

    private Player findPlayerTurn(){
        Player playerTurns = players.removeFirst();
        players.addLast(playerTurns);
        return playerTurns;
    }

    private int jumpCheck(int playerNewPosition){
        if(playerNewPosition > board.cells.length*board.cells.length-1){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump!=null && cell.jump.start==playerNewPosition){
            String jumpby = (cell.jump.start < cell.jump.end) ? "ladder" : "snake";
            System.out.println("jump done by: "+jumpby);
            return cell.jump.end;
        }
        return playerNewPosition;
    }
}
