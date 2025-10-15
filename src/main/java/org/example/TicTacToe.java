package org.example;

public class TicTacToe {
    private final int size = 3;
    private Cell[][] board;

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
                System.out.print("---+---+---"); // Separator between rows
            }
        }
    }
}
