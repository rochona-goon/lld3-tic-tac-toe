package Strategies;

import Models.Board;
import Models.Cell;
import Models.Enums.CellState;
import Models.Move;
import Models.Player;

import java.util.Random;

public class MediumBotStrategy implements BotStrategy {

    @Override
    public Move makeMove(Board board, Player player) {
        Random random = new Random();
        int randomRow = random.nextInt(board.getSize());
        int randomCol = random.nextInt(board.getSize());

        if(board.getCells().get(randomRow).get(randomCol).getCellState().equals(CellState.EMPTY)) {
            return new Move(player, new Cell(randomRow, randomCol));
        }

        return makeMove(board, player);

    }
}
