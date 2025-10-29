package org.example.games.controller.game;

import org.example.games.model.players.Player;
/**
 * Implémentation du jeu de Gomoku (ou "Five in a Row").
 * <p>
 * Cette classe hérite de {@link Game} et définit les règles spécifiques
 * au Gomoku, notamment la condition de victoire : aligner 5 symboles identiques
 * horizontalement, verticalement ou en diagonale.
 * </p>
 *
 * <p>Le plateau est fixé à une taille de 15x15 cases.</p>
 *
 * <p>Ce jeu utilise la logique générique de {@link Game} pour la gestion du
 * tour des joueurs, du plateau et des coups joués, tout en personnalisant
 * la méthode {@link #checkVictory()}.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */
public class Gomoku extends Game {

    public Gomoku(Player[] players) {
        super(15, 15, players);
    }
    /**
     * Vérifie si un joueur a gagné la partie.
     * <p>
     * La victoire est obtenue lorsqu’un joueur aligne 5 symboles identiques
     * de manière consécutive, que ce soit horizontalement, verticalement
     * ou en diagonale.
     * </p>
     *
     * @return {@code true} si un joueur a gagné, {@code false} sinon
     */
    //TODO :
    @Override
    public boolean checkVictory() {
        int boardWidth = getBoard().getWidth();
        int boardHeight = getBoard().getHeight();
        int winningLength = 5;

        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {

                Player currentPlayer = getBoard().getCell(col, row).getOwner();
                if (currentPlayer == null) continue;
                // Directions : droite, bas, diagonale principale, diagonale secondaire
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
