package org.example.games.controller.game;

import org.example.games.model.players.Player;

public class Gomoku extends Game {

    public Gomoku(Player[] players) {
        super(15, 15, players);
    }

    @Override
    public boolean checkVictory() {
        int boardWidth = getBoard().getWidth();
        int boardHeight = getBoard().getHeight();
        int winningLength = 5;

        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {

                Player currentPlayer = getBoard().getCell(col, row).getOwner();
                if (currentPlayer == null) continue;

                int[][] moveDirections = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};

                for (int[] direction : moveDirections) {
                    int colStep = direction[0];
                    int rowStep = direction[1];
                    int samePlayerCount = 1;

                    int nextCol = col + colStep;
                    int nextRow = row + rowStep;

                    while (nextCol >= 0 && nextCol < boardWidth &&
                            nextRow >= 0 && nextRow < boardHeight &&
                            getBoard().getCell(nextCol, nextRow).getOwner() == currentPlayer) {

                        samePlayerCount++;
                        if (samePlayerCount == winningLength) {
                            return true;
                        }

                        nextCol += colStep;
                        nextRow += rowStep;
                    }
                }
            }
        }

        return false;
    }
}
