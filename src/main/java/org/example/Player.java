package org.example;

public abstract class Player {
    //attribut
    protected String representation;
    //méthode
    public Player(String representation){
        this.representation = representation;
    }
    public String getRepresentation() {
        return representation;
    }

    public abstract void makeMove(TicTacToe ticTacToe, View view, InteractionUtilisateur UI);
}
