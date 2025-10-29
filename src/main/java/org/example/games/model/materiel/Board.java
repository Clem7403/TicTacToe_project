package org.example.games.model.materiel;

import org.example.games.model.players.Player;
/**
 * Représente le plateau de jeu.
 * <p>
 * Cette classe gère la grille de cellules, les dimensions du plateau et
 * fournit des méthodes pour accéder aux cellules et vérifier si le plateau
 * est plein.
 * </p>
 *
 * <p>Chaque case est représentée par un objet {@link Cell}, qui peut
 * contenir un joueur ou être vide.</p>
 *
 * <p>Cette classe fait partie du modèle et ne gère pas l'affichage
 * ni la logique de jeu.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */
public class Board {

    private int width;
    private int height;
    private Cell[][] cells;
    /**
     * Constructeur du plateau.
     *
     * @param width  largeur du plateau
     * @param height hauteur du plateau
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    /**
     * Retourne la largeur du plateau.
     *
     * @return largeur du plateau
     */
    public int getWidth() {
        return width;
    }
    /**
     * Retourne la hauteur du plateau.
     *
     * @return hauteur du plateau
     */
    public int getHeight() {
        return height;
    }
    /**
     * Retourne la cellule à la position donnée.
     *
     * @param x coordonnée horizontale
     * @param y coordonnée verticale
     * @return la cellule correspondante
     */
    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
    /**
     * Définit le propriétaire d'une cellule.
     *
     * @param point  position de la cellule
     * @param player joueur à affecter à la cellule
     */
    public void setCellOwner(Point point, Player player) {
        cells[point.getX()][point.getY()].setOwner(player);
    }

    /**
     * Vérifie si toutes les cellules du plateau sont occupées.
     *
     * @return {@code true} si le plateau est plein, {@code false} sinon
     */
    public boolean isBoardFull() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cells[i][j].getOwner() == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
