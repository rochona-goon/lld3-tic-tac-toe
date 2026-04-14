package Strategies;

import Models.Move;

public interface WinningStrategy {
    boolean hasWon(Move move);
}
