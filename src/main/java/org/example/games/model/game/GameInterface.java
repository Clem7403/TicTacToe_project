package org.example.games.model.game;

import org.example.games.model.materiel.Point;
import org.example.games.model.players.Player;

public interface GameInterface {
    boolean playMove(Point point, Player player);

    boolean isOver();

    boolean checkVictory();
}
