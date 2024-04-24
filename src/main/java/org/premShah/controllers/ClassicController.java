package org.premShah.controllers;

import org.premShah.exceptions.InvalidMoveException;
import org.premShah.models.Game;
import org.premShah.models.GameState;
import org.premShah.models.Player;

import java.util.*;

public class ClassicController {
    public Game startGame(int size, List<Player> players) {
        return new Game(size, players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}
