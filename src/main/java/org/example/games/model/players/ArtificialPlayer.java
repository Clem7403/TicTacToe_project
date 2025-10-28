package org.example.games.model.players;

import org.example.games.controller.game.Game;
import org.example.games.model.materiel.Board;
import org.example.games.model.materiel.Point;

import java.util.Random;

public class ArtificialPlayer extends Player {
    private Random random = new Random();

    public ArtificialPlayer(String representation) {
        super(representation);
    }


    @Override
    public Point decideMove(Game game) {
        Board board = game.getBoard();
        int width = board.getWidth();
        int height = board.getHeight();
        int x, y;
        do {
            x = random.nextInt(width);
            y = random.nextInt(height);
        } while (board.getCell(x, y).getOwner() != null);
        return new Point(x, y);
    }
}
