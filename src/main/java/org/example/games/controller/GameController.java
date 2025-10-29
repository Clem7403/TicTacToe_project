package org.example.games.controller;

import org.example.games.controller.game.Game;
import org.example.games.controller.game.Gomoku;
import org.example.games.controller.game.TicTacToe;
import org.example.games.model.materiel.Point;
import org.example.games.model.players.ArtificialPlayer;
import org.example.games.model.players.HumanPlayer;
import org.example.games.model.players.Player;
import org.example.games.view.UserInterface;
import org.example.games.view.View;

/**
 * Contrôleur principal gérant le déroulement global du jeu.
 * <p>
 * Cette classe implémente une machine à états simple permettant de gérer
 * les différentes étapes d'une partie : initialisation, jeu, victoire,
 * match nul et sortie.
 * </p>
 *
 * <p>Elle relie le modèle ({@link Game}) et la vue ({@link View}) en contrôlant
 * le flux des interactions selon le pattern MVC.</p>
 *
 * @author [Ton Nom]
 * @version 1.0
 */
public class GameController {

    private Game game;
    private View view;
    private UserInterface userInterface;
    private State state;

    /**
     * Constructeur par défaut.
     * <p>Initialise la vue, l’interface utilisateur et définit l’état initial à {@code INIT}.</p>
     */

    public GameController() {
        this.view = new View();
        this.userInterface = new UserInterface();
        this.state = State.INIT;
    }

    /**
     * Lance la boucle principale d’interaction du contrôleur.
     * <p>Cette méthode gère la machine à états du jeu et enchaîne les étapes :
     * initialisation, déroulement du jeu, affichage du résultat et redémarrage.</p>
     */
    public void interact() {
        Player winner = null;
        while (state != State.EXIT) {

            switch (state) {
                case INIT:
                    boolean wantToPlay = init();
                    if (wantToPlay) {
                        state = State.PLAY;
                    } else {
                        state = State.EXIT;
                    }
                    break;
                case PLAY:
                    winner = runGameLoop();
                    if (game.checkVictory()) {
                        state = State.WIN;
                    } else {
                        state = State.DRAW;
                    }
                    break;
                case WIN:
                    view.showMessage("Bravo " + winner.getRepresentation() + ", vous avez gagné !");
                    state = State.INIT;
                    break;
                case DRAW:
                    view.showMessage("Match nul !");
                    state = State.INIT;
                    break;


            }
        }
        view.showMessage("Bye !");
    }

    /**
     * Initialise une nouvelle partie et affiche le menu principal.
     *
     * @return {@code true} si l'utilisateur souhaite lancer une partie, {@code false} sinon
     */
    public boolean init() {
        view.showMessage("Bienvenue !");
        int choice = view.getMenuChoice();
        return parseUserChoice(choice);
    }
    /**
     * Analyse le choix du joueur dans le menu et initialise le jeu correspondant.
     *
     * @param choice choix du joueur dans le menu principal
     * @return {@code true} si un jeu a été initialisé, {@code false} sinon
     */


    private boolean parseUserChoice(int choice) {
        Player[] players = new Player[]{new ArtificialPlayer("O"), new HumanPlayer("X")};
        //TODO : ajout d'un menu pour choisir le mode

        switch (choice) {
            case 1:
                game = new TicTacToe(players);
                return true;
            case 2:
                game = new Gomoku(players);
                return true;
            case 0:
                return false;
        }
        return false;
    }
    /**
     * Exécute la boucle principale du jeu tant que la partie n’est pas terminée.
     *
     * @return le dernier joueur à avoir joué (potentiellement le gagnant)
     */
    public Player runGameLoop() {
        Player currentPlayer = null;
        while (!game.isOver()) {
            view.displayBoard(game.getBoard());
            currentPlayer = game.getCurrentPlayer();
            Point move;

            move = getMove(currentPlayer);

            if (!game.playMove(move, currentPlayer)) {
                view.showMessage("Case invalide, sélectionné une autre case.");
            }
        }
        return currentPlayer;
    }
    /**
     * Récupère le coup à jouer pour le joueur courant.
     * <p>
     * Si le joueur est humain, le coup est demandé via l’interface utilisateur.
     * Si c’est un joueur artificiel, le coup est calculé automatiquement.
     * </p>
     *
     * @param currentPlayer joueur dont c’est le tour
     * @return le point correspondant au coup joué
     */
    private Point getMove(Player currentPlayer) {
        Point move;
        if (currentPlayer instanceof HumanPlayer) {
            move = userInterface.getMove(currentPlayer, game);
        } else {
            move = game.getMove(currentPlayer);
        }
        return move;
    }


}
