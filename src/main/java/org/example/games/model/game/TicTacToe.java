package org.example.games.model.game;

import org.example.games.model.players.Player;


public class TicTacToe extends Game {

    public TicTacToe(Player[] players) {
        super(3, 3, players); // plateau 3x3
    }

    @Override
    public boolean checkVictory() {
        int boardWidth = getBoard().getWidth();
        int boardHeight = getBoard().getHeight();
        int winningLength = 3;

        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {

                Player currentPlayer = getBoard().getCell(col, row).getOwner();
                if (currentPlayer == null) continue;

                int[][] moveDirections = { {1, 0}, {0, 1}, {1, 1}, {1, -1} };

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
