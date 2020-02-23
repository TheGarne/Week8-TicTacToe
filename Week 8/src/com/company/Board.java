package com.company;

public class Board {
    //TicTacToe Board


    Pieces[][] createBoard() {
        Pieces [][] board = {{Pieces.e, Pieces.e, Pieces.e}, {Pieces.e, Pieces.e, Pieces.e}, {Pieces.e, Pieces.e, Pieces.e}};
        return board;
    }

    void showBoard(Pieces[][] board) {
        System.out.println("  1 " + " | " + "2 " + "| " + " 3 ");
        System.out.println("1  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("2  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("3  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);

    }
}
