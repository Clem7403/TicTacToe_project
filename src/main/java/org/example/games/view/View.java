package org.example.games.view;

import org.example.games.model.materiel.Board;
/**
 * Classe représentant la vue principale du jeu.
 * <p>
 * Cette classe est responsable de l'affichage du plateau, des messages et
 * du menu. Elle ne contient aucune logique de jeu et se limite à la
 * présentation, respectant ainsi le principe MVC.
 * </p>
 *
 * <p>Elle utilise {@link UserInterface} pour récupérer les entrées
 * utilisateur lorsque nécessaire.</p>
 *
 * <p>Cette classe est indépendante de la logique métier et du contrôleur.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */
public class View {
    UserInterface userInterface = new UserInterface();
    /**
     * Affiche le plateau de jeu dans la console.
     *
     * @param board plateau à afficher
     */
    public void displayBoard(Board board) {
        // Display column numbers header
        System.out.print("  |");
        for (int l = 0; l < board.getWidth(); l++) {
            System.out.print(" " + (l + 1) + " |");
        }
        System.out.println();

        // Display top border
        System.out.print("---");
        for (int k = 0; k < board.getWidth(); k++) {
            System.out.print("----");
        }
        System.out.println();

        // Display board rows with content
        for (int i = 0; i < board.getHeight(); i++) {
            // Display row number
            System.out.print(i + 1 + " |");

            // Display cell contents
            for (int j = 0; j < board.getWidth(); j++) {
                System.out.print(board.getCell(i, j).getRepresentation() + "|");
            }
            System.out.println();

            // Display row separator
            System.out.print("---");
            for (int k = 0; k < board.getHeight(); k++) {
                System.out.print("----");
            }
            System.out.println();
        }
    }

    /**
     * Affiche un message simple dans la console.
     *
     * @param message texte à afficher
     */
    public void showMessage(String message) {
        System.out.println(message);
    }
    /**
     * Affiche le menu principal et récupère le choix de l'utilisateur.
     *
     * @return l'entier correspondant au choix du joueur
     */
    public int getMenuChoice() {
        System.out.println("Choisis à quel jeu jouer :");
        System.out.println("1. Jouer au TicTacToe");
        System.out.println("2. Jouer au Gomoku");
        System.out.println("0. Quitter");
        return userInterface.askForInt();
    }

}

