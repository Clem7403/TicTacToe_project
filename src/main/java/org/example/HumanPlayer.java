package org.example;
import java.util.Scanner;

public class HumanPlayer extends Player {
    //attribut
    private Scanner scanner = new Scanner(System.in);
    //méthode
    public HumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public void makeMove(TicTacToe ticTacToe, View view, InteractionUtilisateur UI) {
        Point move = UI.getMove(view, ticTacToe, this);
        ticTacToe.playMove(move, this);
    }
}
