package org.example.games.view;

import org.example.games.model.materiel.Board;

public class View {

    public void displayBoard(Board board) {
        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getWidth(); x++) {
                System.out.print(board.getCell(x, y).getRepresentation());
                if (x < board.getWidth() - 1) System.out.print("|");
            }
            System.out.println();
            if (y < board.getHeight() - 1) {
                System.out.println("-".repeat(board.getWidth() * 2 - 1));
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}

