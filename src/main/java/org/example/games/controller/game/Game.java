package org.example.games.controller.game;

import org.example.games.model.materiel.Board;
import org.example.games.model.materiel.Point;
import org.example.games.model.players.Player;

/**
 * Classe abstraite représentant le modèle général d'un jeu de plateau.
 * <p>
 * Elle définit la structure et les comportements communs à tous les jeux
 * (comme le TicTacToe ou le Gomoku), en gérant le plateau, les joueurs et le
 * déroulement des tours.
 * </p>
 *
 * <p>Les classes concrètes doivent implémenter la méthode {@link #checkVictory()}
 * afin de définir leurs propres conditions de victoire.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */

public abstract class Game implements GameStrategy {
    private Player[] players;
    private final Board board;
    private int currentPlayerIndex = 0;

    /**
     * Constructeur du jeu.
     *
     * @param width   largeur du plateau de jeu
     * @param height  hauteur du plateau de jeu
     * @param players tableau des joueurs participant à la partie
     */
    public Game(int width, int height, Player[] players) {
        this.players = players;
        this.board = new Board(width, height);
    }
    /**
     * Vérifie si un joueur a remporté la partie.
     * <p>Doit être implémentée par les classes concrètes selon les règles du jeu.</p>
     *
     * @return {@code true} si un joueur a gagné, {@code false} sinon
     */

    public abstract boolean checkVictory();

    /**
     * Indique si la partie est terminée (victoire ou plateau plein).
     *
     * @return {@code true} si la partie est finie, {@code false} sinon
     */

    public boolean isOver() {
        return checkVictory() || board.isBoardFull();
    }

    /**
     * Retourne le joueur dont c’est le tour de jouer.
     *
     * @return le joueur courant
     */
    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }


    /**
     * Joue un coup sur le plateau pour un joueur donné.
     * <p>Si la case est libre, le coup est appliqué et le tour passe au joueur suivant.</p>
     *
     * @param point  coordonnées du coup à jouer
     * @param player joueur effectuant le coup
     * @return {@code true} si le coup est valide et joué, {@code false} sinon
     */
    //TODO : implémenter le tour du joueur dans la classe du jeu

    public boolean playMove(Point point, Player player) {
        if (board.getCell(point.getX(), point.getY()).getOwner() == null) {
            board.setCellOwner(point, player);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
            return true;
        }
        return false;
    }
    /**
     * Demande au joueur de choisir un coup à jouer.
     *
     * @param player joueur courant
     * @return le point choisi par le joueur
     */

    public Point getMove(Player player) {
        return player.decideMove(this);
    }

    /**
     * Retourne le plateau du jeu.
     *
     * @return l’objet {@link Board} représentant le plateau
     */

    public Board getBoard() {
        return board;
    }

    /**
     * Retourne la liste des joueurs de la partie.
     *
     * @return tableau contenant les joueurs
     */
    public Player[] getPlayers() {
        return players;
    }
}


