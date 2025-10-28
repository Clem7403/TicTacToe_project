package org.example.games.controller;

import org.example.games.model.game.Game;
import org.example.games.model.game.Gomoku;
import org.example.games.model.game.TicTacToe;
import org.example.games.model.materiel.Point;
import org.example.games.model.players.ArtificialPlayer;
import org.example.games.model.players.HumanPlayer;
import org.example.games.model.players.Player;
import org.example.games.view.UserInterface;
import org.example.games.view.View;

public class GameController {

    private Game game;
    private View view;
    private UserInterface userInterface;
    private State state;

    public GameController() {
        this.view = new View();
        this.userInterface = new UserInterface();
        this.state = State.INIT;
    }

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

    public boolean init() {
        view.showMessage("Bienvenue !");
        int choice = view.getMenuChoice();
        return parseUserChoice(choice);
    }

    private boolean parseUserChoice(int choice) {
        Player[] players = new Player[]{new ArtificialPlayer("O"), new HumanPlayer("X")};

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
