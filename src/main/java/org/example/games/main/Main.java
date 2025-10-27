package org.example.games.main;

import org.example.games.controller.GameController;
import org.example.games.model.game.Game;
import org.example.games.model.game.Gomoku;
import org.example.games.model.players.ArtificialPlayer;
import org.example.games.model.players.HumanPlayer;
import org.example.games.model.game.TicTacToe;
import org.example.games.view.UserInterface;
import org.example.games.model.players.Player;
import org.example.games.view.View;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        // Créer la vue et l'interface utilisateur
        View view = new View();
        UserInterface ui = new UserInterface();

        // Menu simple pour choisir le jeu
        view.showMessage("Bienvenue !");
        view.showMessage("1 - TicTacToe");
        view.showMessage("2 - Gomoku");
        view.showMessage("0 - Quitter");

        int choice = ui.getMenuChoice(view);

        if (choice == 0) {
            view.showMessage("Au revoir !");
            return;
        }

        // Créer les joueurs
        Player player1 = new HumanPlayer("X");
        Player player2 = new ArtificialPlayer("O");
        Player[] players = {player1, player2};

        // Créer le jeu choisi
        Game game;
        switch (choice) {
            case 1:
                game = new TicTacToe(players);
                break;
            case 2:
                game = new Gomoku(players);
                break;
            default:
                view.showMessage("Choix invalide !");
                return;
        }

        // Créer le contrôleur et démarrer le jeu
        GameController controller = new GameController(game, view, ui);
        controller.start();

    }
}