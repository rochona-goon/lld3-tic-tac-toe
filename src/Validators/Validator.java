package Validators;

import Models.Cell;
import Models.Enums.CellState;

public class Validator {
    public static boolean checkBoardSize(int size){
        if(size < 11 && size > 2)
            return true;

        return false;
    }

    public static boolean isCellEmpty(Cell cell){
        if (cell.getCellState().equals(CellState.EMPTY))
            return true;

        return false;
    }
}
