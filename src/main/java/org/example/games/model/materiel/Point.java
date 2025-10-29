package org.example.games.model.materiel;
/**
 * Représente une position sur le plateau de jeu.
 * <p>
 * Un point est défini par ses coordonnées {@code x} (colonne) et {@code y} (ligne).
 * Cette classe est immuable : une fois créé, un point ne peut pas être modifié.
 * </p>
 *
 * <p>Elle est utilisée pour identifier la position des coups sur le plateau
 * et pour manipuler les cellules de manière générique.</p>
 *
 * <p>Cette classe fait partie du modèle et ne gère ni l’affichage ni la logique
 * de jeu.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */
public class Point {
    private final int x;
    private final int y;

    /**
     * Constructeur d’un point sur le plateau.
     *
     * @param x coordonnée horizontale (colonne)
     * @param y coordonnée verticale (ligne)
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retourne la coordonnée horizontale du point.
     *
     * @return la valeur de {@code x}
     */
    public int getX() {
        return x;
    }
    /**
     * Retourne la coordonnée verticale du point.
     *
     * @return la valeur de {@code y}
     */
    public int getY() {
        return y;
    }
}
