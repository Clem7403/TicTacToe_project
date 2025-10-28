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

    public int askForInt(){
        return scanner.nextInt();
    }


}
