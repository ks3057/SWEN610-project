package com.webcheckers.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class Game {
    private int gameID;
    private boolean playerOneTurn;
    private Human playerOne;
    private Human playerTwo;
    private String winner;
    private String loser;
    private LocalDateTime dateTime = LocalDateTime.now();
    private Board board;
    private boolean hasGameEnded;
    private boolean isEasy = true;

    public Game() {
        this.playerOne = null;
        this.playerTwo = null;

        //TODO no args constructor for board class
//        this.board = new Board();

        // true for player
        // false for opponent
        playerOneTurn = true;
    }

    public ArrayList<Human> getPlayers() {
        ArrayList<Human> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }

}
