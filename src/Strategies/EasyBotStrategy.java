package Strategies;

import Models.Board;
import Models.Cell;
import Models.Enums.CellState;
import Models.Move;
import Models.Player;

public class EasyBotStrategy implements BotStrategy {
    @Override
    public Move makeMove(Board board, Player player) {
        for(int i=0;i< board.getSize(); i++){
            for(int j=0; j<board.getSize(); j++){
                if(board.getCells().get(i).get(j).getCellState().equals(CellState.EMPTY)){

                    return new Move(player,new Cell(i,j));
                }
            }
        }
        return null;
    }
}
