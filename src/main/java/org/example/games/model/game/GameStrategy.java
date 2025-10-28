package org.example.games.model.game;

import org.example.games.model.materiel.Board;
import org.example.games.model.materiel.Point;
import org.example.games.model.players.Player;

public interface GameStrategy {
    boolean playMove(Point point, Player player);
    boolean isOver();
    Board getBoard();
    Player getCurrentPlayer();
    boolean checkVictory();
    Point getMove(Player player);
}
