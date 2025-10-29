package org.example.games.view;

import org.example.games.controller.game.Game;
import org.example.games.model.players.Player;
import org.example.games.model.materiel.Point;

import java.util.Scanner;

/**
 * Classe représentant l'interface utilisateur pour les entrées clavier.
 * <p>
 * Cette classe permet de récupérer les actions du joueur et de fournir
 * les informations nécessaires au contrôleur pour gérer le déroulement
 * du jeu.
 * </p>
 *
 * <p>Elle est indépendante du modèle et de la logique de jeu, respectant
 * le principe MVC.</p>
 *
 * <p>Les méthodes ici lisent des données depuis le terminal.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */
public class UserInterface {

    private Scanner scanner = new Scanner(System.in);
    /**
     * Demande au joueur de saisir son coup et retourne la position choisie.
     *
     * @param player joueur courant
     * @param game   partie en cours
     * @return un objet {@link Point} représentant la case choisie par le joueur
     */
    public Point getMove(Player player, Game game) {
        System.out.println(player.getRepresentation() + ", entre ton coup (x y) : ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Point(x, y);
    }
    /**
     * Lit un entier saisi par l'utilisateur.
     *
     * @return l'entier saisi
     */
    public int askForInt() {
        return scanner.nextInt();
    }


}
