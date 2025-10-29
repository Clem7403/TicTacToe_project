package org.example.games.model.players;

import org.example.games.controller.game.Game;
import org.example.games.model.materiel.Point;
/**
 * Représente un joueur humain dans un jeu de plateau.
 * <p>
 * Cette classe hérite de {@link Player} et sert de modèle pour un joueur
 * dont les actions sont décidées par l'utilisateur via l'interface.
 * </p>
 *
 * <p>La méthode {@link #decideMove(Game)} n’est pas utilisée directement,
 * car le coup est récupéré via la vue et le contrôleur pour respecter le pattern MVC.</p>
 *
 * <p>Cette classe fait partie du modèle et ne gère ni l’affichage ni le déroulement
 * de la partie.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */
public class HumanPlayer extends Player {
    /**
     * Constructeur du joueur humain.
     *
     * @param representation symbole représentant ce joueur sur le plateau
     */
    public HumanPlayer(String representation) {
        super(representation);
    }
    /**
     * Méthode héritée de {@link Player} pour décider d’un coup.
     * <p>
     * Pour un joueur humain, cette méthode retourne {@code null} car le
     * coup est fourni par le contrôleur via la vue.
     * </p>
     *
     * @param game partie en cours
     * @return toujours {@code null}
     */
    @Override
    public Point decideMove(Game game) {
        return null;
    }
}
