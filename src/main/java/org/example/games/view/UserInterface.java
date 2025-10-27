package org.example.games.view;

import org.example.games.model.game.Game;
import org.example.games.model.players.Player;
import org.example.games.model.materiel.Point;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public Point getMove(Player player, Game game) {
        System.out.println(player.getRepresentation() + ", entre ton coup (x y) : ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Point(x, y);
    }

    public int getMenuChoice(View view) {
        System.out.println("Choisis à quel jeu jouer :");
        System.out.println("1. Jouer au TicTacToe");
        System.out.println("2. Jouer au Gomoku");
        System.out.println("0. Quitter");
        return scanner.nextInt();
    }
}
