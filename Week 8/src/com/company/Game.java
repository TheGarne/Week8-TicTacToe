package com.company;

import java.util.Scanner;

class Game {
    //A Game of TicTacToe using Players and Board
    private Scanner input = new Scanner(System.in);

    void newGame() {
        Player player1 = new Player("Player X");
        Player player2 = new Player("Player O");
        Board board = new Board();

        System.out.println("Welcome " + player1.getName() + " and " + player2.getName() + " to TIC TAC TOE EXTREME!");
        System.out.println(player1.getName() + " is 'x', " + player2.getName() + " is 'o' and e is empty space");

        Pieces[][] gameboard = board.createBoard();
        board.showBoard(gameboard);

        player1.setTurn(true);

        do {
            if(player1.isTurn()) {
                player1Turn(player1, player2, gameboard);
                board.showBoard(gameboard);
            }
            if(player2.isTurn()) {
                player2Turn(player2, player1, gameboard);
                board.showBoard(gameboard);
            }
        } while(winConditions(gameboard, player1, player2));

        System.out.println("Program closing!");

    }

    private void player1Turn(Player player1, Player player2, Pieces[][] board) {
        System.out.println(player1.getName() + "'s turn! ");

        System.out.println("Select Row: ");
        int playRow = input.nextInt() - 1;
        System.out.println("Select Column: ");
        int playCol = input.nextInt() - 1;

        if(playCol > 2 || playCol < 0 || playRow > 2 || playRow < 0) {
            System.out.println("Invalid input... try again");
            playCol = 0;
            playRow = 0;
            player1Turn(player1, player2, board);
        }

        if(player1.isTurn()) {
            if (board[playRow][playCol].equals(Pieces.e)) {
                board[playRow][playCol] = Pieces.x;
                player1.setTurn(false);
                player2.setTurn(true);
            } else {
                System.out.println("You cannot place a piece on this tile... Try again ");
                player1Turn(player1, player2, board);
            }
        }
    }

    private void player2Turn(Player player2, Player player1, Pieces[][] board) {
        System.out.println(player2.getName());

        System.out.println("Select Row: ");
        int playRow = input.nextInt() - 1;
        System.out.println("Select Column: ");
        int playCol = input.nextInt() - 1;

        if(playCol > 2 || playCol < 0 || playRow > 2 || playRow < 0) {
            System.out.println("Invalid input... try again");
            playCol = 0;
            playRow = 0;
            player2Turn(player2, player1, board);
        }

        if(player2.isTurn()) {
            if (board[playRow][playCol].equals(Pieces.e)) {
                board[playRow][playCol] = Pieces.o;
                player1.setTurn(true);
                player2.setTurn(false);
            } else {
                System.out.println("You cannot place a piece on this tile... Try again ");
                player2Turn(player2, player1, board);
            }
        }
    }

    private boolean winConditions(Pieces[][] board, Player player1, Player player2) {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                //Horizontal win condition
                if((board[row][0].equals(Pieces.x) && board[row][1].equals(Pieces.x) && board[row][2].equals(Pieces.x))
                        || (board[row][0].equals(Pieces.o) && board[row][1].equals(Pieces.o) && board[row][2].equals(Pieces.o)) ) {
                    System.out.println("Win condition 1");
                    return false;
                }

                //Vertical win condition
                if((board[0][col].equals(Pieces.x) && board[1][col].equals(Pieces.x) && board[2][row].equals(Pieces.x))
                        || (board[0][row].equals(Pieces.o) && board[1][col].equals(Pieces.o) && board[2][col].equals(Pieces.o)) ) {
                    System.out.println("Win condition 2");
                    return false;
                }

                //No more available spaces
                if(!board[row][col].equals(Pieces.e) && !board[0][0].equals(Pieces.e) && !board[1][1].equals(Pieces.e) && !board[2][2].equals(Pieces.e) && !board[0][2].equals(Pieces.e) && !board[2][0].equals(Pieces.e) && !board[1][2].equals(Pieces.e)) {
                    System.out.println("Game over: Draw!");
                    return false;
                }
            }

        //Diagonal down win condition
        if((board[0][0].equals(Pieces.x) && board[1][1].equals(Pieces.x) && board[2][2].equals(Pieces.x))
                || (board[0][0].equals(Pieces.o) && board[1][1].equals(Pieces.o) && board[2][2].equals(Pieces.o))) {
            System.out.println("Win condition 3");
            return false;
        }

        //Diagonal up win condition
        if((board[2][0].equals(Pieces.x) && board[1][1].equals(Pieces.x) && board[0][2].equals(Pieces.x))
                || (board[2][0].equals(Pieces.o) && board[1][1].equals(Pieces.o) && board[0][2].equals(Pieces.o))) {
            System.out.println("Win condition 4");
            return false;
        }
        }

        return true;
    }
}
