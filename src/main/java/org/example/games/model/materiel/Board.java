package org.example.games.model.materiel;

import org.example.games.model.players.Player;

public class Board {

    private int width;
    private int height;
    private Cell[][] cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setCellOwner(Point point, Player player) {
        cells[point.getX()][point.getY()].setOwner(player);
    }

    public boolean isBoardFull() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cells[i][j].getOwner() == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
