package Models;

import Models.Enums.GameState;
import Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private int nextPlayerIdx;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;

    public Game(int size, List<Player> players, List<Move> moves, Player winner,
                int nextPlayerIdx, List<WinningStrategy> winningStrategies) {
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>(); // Initially no moves
        this.winner = winner;
        this.nextPlayerIdx = 0; // Index of first player in the List
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
    }




    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIdx() {
        return nextPlayerIdx;
    }

    public void setNextPlayerIdx(int nextPlayerIdx) {
        this.nextPlayerIdx = nextPlayerIdx;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategy(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
}
