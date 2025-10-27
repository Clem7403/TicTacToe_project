package org.example.games.model.game;

import org.example.games.model.materiel.Board;
import org.example.games.model.materiel.Point;
import org.example.games.model.players.Player;

public abstract class Game implements GameInterface {
    private Player[] players;
    private final Board board;
    private int currentPlayerIndex = 0;

    public Game(int width, int height, Player[] players) {
        this.players = players;
        this.board = new Board(width, height);
    }

    public abstract boolean checkVictory();

    public boolean isOver() {
        return checkVictory() || board.isBoardFull();
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public boolean playMove(Point point, Player player) {
        if (board.getCell(point.getX(), point.getY()).getOwner() == null) {
            board.setCellOwner(point, player);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
            return true;
        }
        return false;
    }

    public Board getBoard() {
        return board;
    }

    public Player[] getPlayers() {
        return players;
    }
}


