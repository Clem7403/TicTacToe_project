package org.example.games.view;

import org.example.games.model.materiel.Board;

public class View {
    UserInterface userInterface = new UserInterface();

    public void displayBoard(Board board) {
        // Display column numbers header
        System.out.print("  |");
        for (int l = 0; l < board.getWidth(); l++) {
            System.out.print(" " + (l + 1) + " |");
        }
        System.out.println();

        // Display top border
        System.out.print("---");
        for (int k = 0; k < board.getWidth(); k++) {
            System.out.print("----");
        }
        System.out.println();

        // Display board rows with content
        for (int i = 0; i < board.getHeight(); i++) {
            // Display row number
            System.out.print(i + 1 + " |");

            // Display cell contents
            for (int j = 0; j < board.getWidth(); j++) {
                System.out.print(board.getCell(i, j).getRepresentation() + "|");
            }
            System.out.println();

            // Display row separator
            System.out.print("---");
            for (int k = 0; k < board.getHeight(); k++) {
                System.out.print("----");
            }
            System.out.println();
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int getMenuChoice() {
        System.out.println("Choisis à quel jeu jouer :");
        System.out.println("1. Jouer au TicTacToe");
        System.out.println("2. Jouer au Gomoku");
        System.out.println("0. Quitter");
        return userInterface.askForInt();
    }

}

