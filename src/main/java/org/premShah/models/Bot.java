package org.premShah.models;

import org.premShah.models.BotType;
import org.premShah.models.Symbol;

import java.util.List;

public class Bot extends Player {
    private BotType botlevel;

    public Bot(String name, Symbol symbol, BotType botlevel) {
        super(name, symbol, PlayerType.COMPUTER);
        this.botlevel = botlevel;
    }

    public BotType getBotLevel() {
        return botlevel;
    }

    public void setBotLevel(BotType botlevel) {
        this.botlevel = botlevel;
    }

    public Move makeMove(Board board) {
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getState().equals(CellState.EMPTY)) {
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}
