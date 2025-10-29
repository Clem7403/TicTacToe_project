package org.example.games.model.players;

import org.example.games.controller.game.Game;
import org.example.games.model.materiel.Point;
/**
 * Classe abstraite représentant un joueur dans un jeu de plateau.
 * <p>
 * Un joueur est défini par sa représentation (symbole affiché sur le plateau)
 * et doit fournir une méthode pour décider de son coup via {@link #decideMove(Game)}.
 * </p>
 *
 * <p>Cette classe est étendue par {@link HumanPlayer} et {@link ArtificialPlayer}
 * pour fournir des comportements spécifiques à chaque type de joueur.</p>
 *
 * <p>Elle fait partie du modèle et ne gère ni l’affichage ni le déroulement
 * de la partie.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */
public abstract class Player {

    private String representation;

    /**
     * Constructeur d'un joueur.
     *
     * @param representation symbole représentant ce joueur sur le plateau
     */
    public Player(String representation) {
        this.representation = representation;
    }
    /**
     * Retourne la représentation textuelle du joueur.
     * <p>
     * Cette représentation est utilisée pour afficher le joueur sur le plateau.
     * </p>
     *
     * @return représentation textuelle du joueur
     */
    public String getRepresentation() {
        return " " + representation + " ";
    }

    /**
     * Modifie la représentation du joueur.
     *
     * @param representation nouveau symbole du joueur
     */
    public void setRepresentation(String representation) {
        this.representation = representation;
    }
    /**
     * Méthode abstraite pour décider d’un coup.
     * <p>
     * Pour un joueur humain, la décision sera fournie par la vue via le contrôleur.
     * Pour un joueur artificiel, la décision sera calculée automatiquement.
     * </p>
     *
     * @param game partie en cours
     * @return position du coup choisi sous forme de {@link Point}
     */
    public abstract Point decideMove(Game game);
}
