package org.premShah.models;

import java.util.*;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int n) {
        this.size = n;
        board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Cell> row = new ArrayList<>();
            board.add(row);
            for (int j = 0; j < n; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void printBoard() {
        for (List<Cell> row : board) {
            for (Cell cell : row) {
                if (cell.getState().equals(CellState.EMPTY)) {
                    System.out.print("| -- |");
                } else {
                    System.out.print("| " + cell.getPlayer().getSymbol().getChr() + " |");
                }
            }
            System.out.println();
        }
    }
}