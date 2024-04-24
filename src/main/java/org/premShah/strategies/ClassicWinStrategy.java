package org.premShah.strategies;

import org.premShah.models.Board;
import org.premShah.models.Move;

import java.util.HashMap;

public class ClassicWinStrategy {
    HashMap<Integer, HashMap<Character, Integer>> rowMap = new HashMap<>();
    HashMap<Integer, HashMap<Character, Integer>> colMap = new HashMap<>();
    HashMap<Character, Integer> lDiagMap = new HashMap<>();
    HashMap<Character, Integer> rDiagMap = new HashMap<>();

    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character playerSymbol = move.getPlayer().getSymbol().getChr();

        if (!rowMap.containsKey(row)) {
            rowMap.put(row, new HashMap<>());
        }
        HashMap<Character, Integer> currRowMap = rowMap.get(row);

        if (!currRowMap.containsKey(playerSymbol)) {
            currRowMap.put(playerSymbol, 1);
        } else {
            currRowMap.put(playerSymbol, currRowMap.get(playerSymbol) + 1);
        }

        if (currRowMap.get(playerSymbol) == board.getSize()) {
            return true;
        }

        if (!colMap.containsKey(col)) {
            colMap.put(col, new HashMap<>());
        }
        HashMap<Character, Integer> currColMap = colMap.get(col);

        if (!currColMap.containsKey(playerSymbol)) {
            currColMap.put(playerSymbol, 1);
        } else {
            currColMap.put(playerSymbol, currColMap.get(playerSymbol) + 1);
        }

        if (currColMap.get(playerSymbol) == board.getSize()) {
            return true;
        }

        if (row == col) {
            if (!lDiagMap.containsKey(playerSymbol)) {
                lDiagMap.put(playerSymbol, 1);
            } else {
                lDiagMap.put(playerSymbol, lDiagMap.get(playerSymbol) + 1);
            }

            if (lDiagMap.get(playerSymbol) == board.getSize()) {
                return true;
            }
        }

        if (row + col == board.getSize() - 1) {
            if (!rDiagMap.containsKey(playerSymbol)) {
                rDiagMap.put(playerSymbol, 1);
            } else {
                rDiagMap.put(playerSymbol, rDiagMap.get(playerSymbol) + 1);
            }

            if (rDiagMap.get(playerSymbol) == board.getSize()) {
                return true;
            }
        }

        return false;
    }
}
