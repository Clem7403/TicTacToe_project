package org.example;

import javax.swing.text.html.parser.Parser;
import java.util.Scanner;

public class TicTacToe {
    private final int size = 3;
    private final Cell[][] board;
    private final Player[] players = {new Player("X"), new Player("O")};
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

    public Point getMoveFromPlayer(Player player){
        int moveX;
        int moveY;
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
                continue;
            }

            if (board[moveX][moveY].getOwner() != null){
                System.out.println("Erreur, cette case est déjà utilisé");
                continue;
            }
            return new Point(moveX,moveY);
        }

    }

        public Boolean playMove(Point point, Player player){
            if(board[point.getX()][point.getY()].getOwner() != null){
                return false;
            } else {
                board[point.getX()][point.getY()].setOwner(player);
            } return true;
        }

    public void play(){
        int currentPlayerIndex = 0;
        while(!isOver()){
            display();
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println("C'est au tour du joueur " + currentPlayer.getRepresentation());
            Point point = getMoveFromPlayer(currentPlayer);
            playMove(point, currentPlayer);

            currentPlayerIndex = 1 - currentPlayerIndex;
        }
        System.out.println("Match nul !");

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

    public Boolean isOver() {
        // Vérifier les lignes
        for (int i = 0; i < size; i++) {
            if (board[i][0].getOwner() != null
                    && board[i][0].getOwner() == board[i][1].getOwner()
                    && board[i][1].getOwner() == board[i][2].getOwner()) {
                return true;  // victoire horizontale
            }
        }

        // Vérifier les colonnes
        for (int j = 0; j < size; j++) {
            if (board[0][j].getOwner() != null
                    && board[0][j].getOwner() == board[1][j].getOwner()
                    && board[1][j].getOwner() == board[2][j].getOwner()) {
                return true;  // victoire verticale
            }
        }

        // Vérifier les diagonales
        if (board[0][0].getOwner() != null
                && board[0][0].getOwner() == board[1][1].getOwner()
                && board[1][1].getOwner() == board[2][2].getOwner()) {
            return true;
        }
        if (board[0][2].getOwner() != null
                && board[0][2].getOwner() == board[1][1].getOwner()
                && board[1][1].getOwner() == board[2][0].getOwner()) {
            return true;
        }

        // Vérifier si le plateau est plein
        return isBoardFull();
    }


    // Getter for testing
    public Cell[][] getBoard(){
        return board;
    }
    public int getSize(){
        return size;
    }
}
