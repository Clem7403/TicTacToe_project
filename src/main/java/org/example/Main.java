package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       View view = new View();
       InteractionUtilisateur UI = new InteractionUtilisateur();

       int choice = UI.getMenuChoice(view);
        Player player1, player2;

        switch (choice) {
            case 1:
                player1 = new HumanPlayer("X");
                player2 = new HumanPlayer("O");
                break;
            case 2:
                player1 = new HumanPlayer("X");
                player2 = new ArtificialPlayer("O");
                break;
            case 3:
                player1 = new ArtificialPlayer("X");
                player2 = new ArtificialPlayer("O");
                break;
            default:
                System.out.println("Votre choix est invalide ! Sélection du mode par défaut Humain vs Humain.");
                player1 = new HumanPlayer("X");
                player2 = new HumanPlayer("O");

        }

        TicTacToe ticTacToe = new TicTacToe(player1, player2);
        ticTacToe.play(view, UI);

    }
}