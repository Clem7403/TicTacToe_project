package org.example;

import javax.swing.text.html.parser.Parser;
import java.util.Scanner;

public class TicTacToe {
    private final int size = 3;
    private final Cell[][] board;
    private final Player[] players;
    Scanner scanner = new Scanner(System.in);


    public TicTacToe(Player player1, Player player2) {
        this.players = new Player[]{player1, player2};

        board = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0 ; j < size; j++){
                board[i][j] = new Cell();
            }
        }
    }



    public void display(){
        for(int i = 0 ; i < size; i++){
            //Display each row
            for(int j = 0; j < size; j++){
                System.out.print(board[i][j].getRepresentation());
                if (j < size -1) System.out.print("|"); // Separator between cells
            }
            System.out.println(); // New line after each row
            if (i < size -1){
                System.out.println("---+---+---"); // Separator between rows
            }
        }
    }
    public void setOwner(int x, int y, Player player){
        if (x >= 0 && x < size && y >= 0 && y < size && board[x][y].getOwner() == null) {
            board[x][y].setOwner(player);
        }
    }


        public Boolean playMove(Point point, Player player){
            if(board[point.getX()][point.getY()].getOwner() != null){
                return false;
            } else {
                board[point.getX()][point.getY()].setOwner(player);
            } return true;
        }

    public void play() {
        int currentPlayerIndex = 0;
        while (!isOver()) {
            display();
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println("C'est au tour de " + currentPlayer.getRepresentation());
            currentPlayer.makeMove(this);

            //changement de joueur
            currentPlayerIndex = 1 - currentPlayerIndex;
        }

        display();
        if (isBoardFull() && !checkVictory()) {
            System.out.println("Match nul ");
        }
        System.out.println("Le joueur " + players[1 - currentPlayerIndex].getRepresentation());
    }



    public Boolean isBoardFull(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j].getOwner()== null){
                    return false;
                }
            }
        } return true;
    }

    private boolean checkVictory(){
        // Lignes
        for(int i = 0; i < size; i++){
            if(board[i][0].getOwner() != null
                    && board[i][0].getOwner() == board[i][1].getOwner()
                    && board[i][1].getOwner() == board[i][2].getOwner())
                return true;
        }

        // Colonnes
        for(int j = 0; j < size; j++){
            if(board[0][j].getOwner() != null
                    && board[0][j].getOwner() == board[1][j].getOwner()
                    && board[1][j].getOwner() == board[2][j].getOwner())
                return true;
        }

        // Diagonales
        if(board[0][0].getOwner() != null
                && board[0][0].getOwner() == board[1][1].getOwner()
                && board[1][1].getOwner() == board[2][2].getOwner())
            return true;

        if(board[0][2].getOwner() != null
                && board[0][2].getOwner() == board[1][1].getOwner()
                && board[1][1].getOwner() == board[2][0].getOwner())
            return true;

        return false;
    }

    public boolean isOver(){
        return checkVictory() || isBoardFull();
    }



    // Getter for testing
    public Cell[][] getBoard(){
        return board;
    }
    public int getSize(){
        return size;
    }
    public Player[] getPlayers(){return players;}
}
