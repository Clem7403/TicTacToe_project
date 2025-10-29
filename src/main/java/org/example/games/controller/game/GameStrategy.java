package org.example.games.controller.game;

import org.example.games.model.materiel.Board;
import org.example.games.model.materiel.Point;
import org.example.games.model.players.Player;
/**
 * Interface représentant la stratégie de jeu générique.
 * <p>
 * Elle définit le comportement commun à tous les jeux de plateau (TicTacToe, Gomoku, etc.)
 * et permet de rendre le moteur de jeu extensible via le design pattern Strategy.
 * </p>
 *
 * <p>Chaque implémentation de cette interface (comme {@link TicTacToe} ou {@link Gomoku})
 * définit ses propres règles de victoire et son déroulement de partie.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */
public interface GameStrategy {

    /**
     * Joue un coup sur le plateau pour un joueur donné.
     *
     * @param point  position du coup à jouer
     * @param player joueur courant
     * @return {@code true} si le coup est valide et joué, {@code false} sinon
     */
    boolean playMove(Point point, Player player);
    /**
     * Vérifie si la partie est terminée (victoire ou plateau plein).
     *
     * @return {@code true} si la partie est terminée, {@code false} sinon
     */
    boolean isOver();
    /**
     * Retourne le plateau de jeu actuel.
     *
     * @return l’objet {@link Board} représentant le plateau
     */
    Board getBoard();
    /**
     * Retourne le joueur dont c’est le tour de jouer.
     *
     * @return le joueur courant
     */
    Player getCurrentPlayer();
    /**
     * Vérifie si un joueur a remporté la partie.
     *
     * @return {@code true} si un joueur a gagné, {@code false} sinon
     */
    boolean checkVictory();

    /**
     * Demande ou calcule le coup à jouer pour un joueur donné.
     *
     * @param player joueur dont c’est le tour
     * @return la position choisie pour le prochain coup
     */
    Point getMove(Player player);
}
