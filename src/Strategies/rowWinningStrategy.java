package Strategies;

import Models.Move;

import java.util.HashMap;

public class rowWinningStrategy implements WinningStrategy{
    int size;
    HashMap<String, Integer> rowCounter[];

    public rowWinningStrategy(int size) {
        this.size = size;
        this.rowCounter =new HashMap[size];
        for(int i=0; i<size; i++) {
            this.rowCounter[i] = new HashMap<>();
        }
    }


    @Override
    public boolean hasWon(Move move) {
        int row = move.getCell().getRow();

        // get curr row from hashmap
        HashMap<String, Integer> currRow = rowCounter[row];

        String currSymbol = move.getPlayer().getSymbol().getSymbolName();

        if(!currRow.containsKey(currSymbol)){
            currRow.put(currSymbol, 1);
        }else{
            currRow.put(currSymbol, currRow.get(currSymbol) + 1);
        }

        // OR ...
        // currRow.put(currSymbol, currRow.getOrDefault(currSymbol, 0) + 1);

        if(currRow.get(currSymbol) == size){
            return true;
        }

        return false;
    }
}
