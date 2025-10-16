package org.example;
import org.example.TicTacToe;

public class Cell {

    private Player owner;
    //Returns the string representation of the cell
    public String getRepresentation(){
        if(owner == null){
            return "   ";
        } else {
            return owner.getRepresentation();
        }
    }
    public void setOwner(Player player){
        this.owner = player;
    }


}
