package org.example.games.model.materiel;

import org.example.games.model.players.Player;
/**
 * Représente une cellule du plateau de jeu.
 * <p>
 * Chaque cellule peut être vide ou appartenir à un joueur.
 * La classe fournit des méthodes pour obtenir le propriétaire et
 * la représentation visuelle de la cellule.
 * </p>
 *
 * <p>Cette classe fait partie du modèle et ne gère ni la logique de jeu
 * ni l'affichage complet du plateau.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */
public class Cell {

    private Player owner;
    /**
     * Retourne une représentation textuelle de la cellule.
     * <p>
     * Si la cellule est vide, retourne un espace vide.
     * Si elle est occupée, retourne la représentation du joueur.
     * </p>
     *
     * @return la représentation textuelle de la cellule
     */
    //Returns the string representation of the cell
    public String getRepresentation() {
        if (owner == null) {
            return "   ";
        } else {
            return owner.getRepresentation();
        }
    }
    /**
     * Définit le propriétaire de la cellule.
     *
     * @param player joueur à affecter à cette cellule
     */
    public void setOwner(Player player) {
        this.owner = player;
    }
    /**
     * Retourne le joueur possédant cette cellule.
     *
     * @return le joueur propriétaire, ou {@code null} si la cellule est vide
     */
    public Player getOwner() {
        return owner;
    }


}
