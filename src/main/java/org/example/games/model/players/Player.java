package org.example.games.model.players;

import org.example.games.model.game.Game;
import org.example.games.model.materiel.Point;

public abstract class Player {

    private String representation;


    public Player(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return " " + representation + " ";
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    public abstract Point decideMove(Game game);
}
