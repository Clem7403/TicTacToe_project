package org.example.games.model.materiel;

import org.example.games.model.players.Player;

public class Cell {

    private Player owner;

    //Returns the string representation of the cell
    public String getRepresentation() {
        if (owner == null) {
            return "   ";
        } else {
            return owner.getRepresentation();
        }
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public Player getOwner() {
        return owner;
    }


}
