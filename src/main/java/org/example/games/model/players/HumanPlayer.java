package org.example.games.model.players;

import org.example.games.controller.game.Game;
import org.example.games.model.materiel.Point;

public class HumanPlayer extends Player {

    public HumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public Point decideMove(Game game) {
        return null;
    }
}
