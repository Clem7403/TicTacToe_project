package org.example.games.model.players;

import org.example.games.controller.game.Game;
import org.example.games.model.materiel.Board;
import org.example.games.model.materiel.Point;

import java.util.Random;

/**
 * Représente un joueur artificiel (IA) dans un jeu de plateau.
 * <p>
 * Cette classe hérite de {@link Player} et fournit une implémentation
 * automatique pour choisir un coup valide sur le plateau.
 * </p>
 *
 * <p>Le coup est choisi aléatoirement parmi les cases libres du plateau.</p>
 *
 * <p>Cette classe fait partie du modèle et ne gère ni l’affichage ni le déroulement
 * de la partie (ces responsabilités appartiennent au contrôleur et à la vue).</p>
 *
 * <p>Elle respecte le pattern Strategy via {@link Player#decideMove(Game)}.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */
public class ArtificialPlayer extends Player {
    private Random random = new Random();

    /**
     * Constructeur du joueur artificiel.
     *
     * @param representation symbole représentant ce joueur sur le plateau
     */
    public ArtificialPlayer(String representation) {
        super(representation);
    }

    /**
     * Décide automatiquement d’un coup valide à jouer.
     * <p>
     * La méthode choisit aléatoirement une case vide sur le plateau.
     * </p>
     *
     * @param game partie en cours
     * @return la position choisie sous forme d’un {@link Point}
     */
    @Override
    public Point decideMove(Game game) {
        Board board = game.getBoard();
        int width = board.getWidth();
        int height = board.getHeight();
        int x, y;
        do {
            x = random.nextInt(width);
            y = random.nextInt(height);
        } while (board.getCell(x, y).getOwner() != null);
        return new Point(x, y);
    }
}
