package Strategies;

import Models.Move;

import java.util.HashMap;

public class diagonalWinningStrategy implements WinningStrategy {

    int size;
    HashMap<String, Integer>[] digCounter;


    public diagonalWinningStrategy(int size) {
        this.size = size;
        digCounter = new HashMap[2];
        for (int i = 0; i < 2; i++) {
            digCounter[i] = new HashMap<>();
//            System.out.println(i+": "+digCounter[i]);
        }

    }

    //    HashMap<String, Integer> currDig;
    @Override
    public boolean hasWon(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        //        Player currPlayer = move.getPlayer();
        String currSymbol = move.getPlayer().getSymbol().getSymbolName();

        if (row == col && row + col == size - 1) {
            digCounter[0].put(currSymbol, digCounter[0].getOrDefault(currSymbol, 0) + 1);
            digCounter[1].put(currSymbol, digCounter[1].getOrDefault(currSymbol, 0) + 1);

            if(digCounter[0].get(currSymbol) == size)
                return true;

            if(digCounter[1].get(currSymbol) == size)
                return true;

        } else if (row == col) {
            digCounter[0].put(currSymbol, digCounter[0].getOrDefault(currSymbol, 0) + 1);

            if(digCounter[0].get(currSymbol) == size)
                return true;

        } else if (row + col == size - 1) {
            digCounter[1].put(currSymbol, digCounter[1].getOrDefault(currSymbol, 0) + 1);

            if(digCounter[1].get(currSymbol) == size)
                return true;
        } else {
            return false;
        }

//        for (int i = 0; i < 2; i++) {
//            System.out.println(i+": "+digCounter[i]);
//        }


        return false;
    }
}
