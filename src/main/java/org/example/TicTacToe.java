package org.example;

import javax.swing.text.html.parser.Parser;
import java.util.Scanner;

public class TicTacToe {
    private final int size = 3;
    private final Cell[][] board;
    private Player[] players = {new Player("X"), new Player("O")};
    int currentPlayerIndex = 0;
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
            System.out.print("Entrer la ligne (1-3) : ");
            moveX = scanner.nextInt();
            System.out.print("Entrer la colonne (1-3) : ");
            moveY = scanner.nextInt();
            moveX = moveX -1;
            moveY = moveY -1;
            if(moveX<0 || moveX>= size || moveY<0 ||moveY>=size){
                System.out.println("Erreur, coordonnées en dehors des limites.");
            } if (board[moveX][moveY].getOwner() != null){
                System.out.println("Erreur, cette case est déjà utilisé");
            } else {
                Point point = new Point(moveX,moveY);
                board[point.getX()][point.getY()].setOwner(player);
                System.out.println(board[point.getX()][point.getY()].getOwner().getRepresentation());
                display();
                break;
            }
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
