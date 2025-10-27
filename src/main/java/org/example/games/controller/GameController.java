package org.example.games.controller;

import org.example.games.model.game.Game;
import org.example.games.model.materiel.Point;
import org.example.games.model.players.HumanPlayer;
import org.example.games.model.players.Player;
import org.example.games.view.UserInterface;
import org.example.games.view.View;

public class GameController {

    private Game game;
    private View view;
    private UserInterface userInterface;

    public GameController(Game game, View view, UserInterface userInterface) {
        this.game = game;
        this.view = view;
        this.userInterface = userInterface;
    }

    public void start() {
        view.showMessage("Bienvenue !");
        runGameLoop();
    }

    public void runGameLoop() {
        while (!game.isOver()) {
            view.displayBoard(game.getBoard());
            Player currentPlayer = game.getCurrentPlayer();
            Point move;

            //Supprimer le choix
            if (currentPlayer instanceof HumanPlayer) {
                move = userInterface.getMove(currentPlayer, game);
            } else {
                move = currentPlayer.decideMove(game);
            }

            if (!game.playMove(move, currentPlayer)) {
                view.showMessage("Case invalide, sélectionné une autre case.");
            }
        }
        handleVictory();
    }

    public void handleVictory() {
        view.displayBoard(game.getBoard());
        if (game.checkVictory()) {
            Player winner = game.getCurrentPlayer();
            view.showMessage("Le gagnant est : " + winner.getRepresentation());
        } else {
            view.showMessage("Match nul !");
        }
    }
}
