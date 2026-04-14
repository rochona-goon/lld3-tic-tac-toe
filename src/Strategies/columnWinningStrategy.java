package Strategies;

import Models.Move;

import java.util.HashMap;

public class columnWinningStrategy implements WinningStrategy{
    int size;
    HashMap<String, Integer> colCounter[];

    public columnWinningStrategy(int size) {
        this.colCounter = new HashMap[size];
    }


    @Override
    public boolean hasWon(Move move) {
        int col = move.getCell().getCol();
//        Player currPlayer = move.getPlayer();
        // get curr row from hashmap
        HashMap<String, Integer> currCol = colCounter[col];

        String currSymbol = move.getPlayer().getSymbol().getSymbolName();

        currCol.put(currSymbol, currCol.getOrDefault(currSymbol, 0) + 1);

        if(currCol.get(currSymbol) == size)
            return true;

        return false;
    }
}
