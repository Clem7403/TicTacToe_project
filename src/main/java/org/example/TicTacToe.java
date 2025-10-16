package org.example;

import javax.swing.text.html.parser.Parser;
import java.util.Scanner;

public class TicTacToe {
    private final int size = 3;
    private final Cell[][] board;
    private Player player;
    Scanner scanner = new Scanner(System.in);

    public TicTacToe() {
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
    public void setOwner(int x, int y,  Player player){
    Cell cell  = board[x][y];
    if(x >= 0 && x < board.length && y >= 0 && y < board[x].length){
        if(board[x][y].getRepresentation().equals(cell.getRepresentation())){
            cell.setOwner(player);
        }
    }

    }

    public void getMoveFromPlayer(int moveX, int moveY, Player player){
        while (true){
            display();
            System.out.print("Entrer les coordonnées de votre coup (x,y): ");
            moveX = scanner.nextInt();
            moveY = scanner.nextInt();
            if(moveX >=)
        }
    }


    // Getter for testing
    public Cell[][] getBoard(){
        return board;
    }
    public int getSize(){
        return size;
    }
}
