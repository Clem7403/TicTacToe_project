package org.example;

public class View {

    public void displayBoard(TicTacToe ticTacToe){
        System.out.println("    1   2   3");
        for(int i = 0; i < ticTacToe.getSize(); i++){
            System.out.print((i + 1)+ " ");
            for(int j = 0; j < ticTacToe.getSize(); j++){
                System.out.print(" " + ticTacToe.getBoard()[i][j].getRepresentation().trim() + " ");
                if(j<ticTacToe.getSize()-1) System.out.print("|");
                }
            System.out.println();
            if(i<ticTacToe.getSize()-1)System.out.print("   ---+---+---");
            }
        System.out.println();
        }

        public void showMessage(String message){
        System.out.println(message);
        }
    }

