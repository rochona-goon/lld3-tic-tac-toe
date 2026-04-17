package Strategies;

import Models.Board;
import Models.Move;
import Models.Player;

public interface BotStrategy {
    Move makeMove(Board board, Player player);
}
