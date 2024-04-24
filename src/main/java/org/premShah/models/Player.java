package org.premShah.models;

import java.util.*;

import java.util.Scanner;

public class Player {

    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private static Scanner scan = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        System.out.println("Enter row to place your symbol : ");
        int row = scan.nextInt();
        System.out.println("Enter column to place your symbol : ");
        int col = scan.nextInt();

        return new Move(new Cell(row, col), this);
    }
}
