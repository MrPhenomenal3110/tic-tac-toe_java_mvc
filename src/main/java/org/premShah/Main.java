package org.premShah;


import org.premShah.controllers.ClassicController;
import org.premShah.exceptions.InvalidMoveException;
import org.premShah.models.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        ClassicController gameController = new ClassicController();

        int dimension = 3;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter player's name : ");
        String player1Name = scan.next();
        System.out.println("Enter symbol for "+player1Name+" : ");
        String player1Symbol = scan.next();

        List<Player> players = List.of(
                new Player(player1Name, new Symbol(player1Symbol.charAt(0)), PlayerType.HUMAN),
                new Bot("NoobBot", new Symbol('O'), BotType.EASY));

        Game game = gameController.startGame(dimension, players);

        while (game.getGameState().equals(GameState.IN_PROGRESS)) {
            gameController.printBoard(game);

            gameController.makeMove(game);
        }

        if (!gameController.checkState(game).equals(GameState.ENDED)) {
            game.setGameState(GameState.DRAW);
            System.out.println("Game Draw !");
        } else {
            gameController.printBoard(game);
            System.out.println(gameController.getWinner(game).getName() + " has won the game !");
        }
    }
}