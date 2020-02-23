package com.company;

public class Player {
    //TicTacToe Players

    private String name = "";
    private boolean turn = false;

    Player(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    boolean isTurn() {
        return turn;
    }

    void setTurn(boolean turn) {
        this.turn = turn;
    }
}
