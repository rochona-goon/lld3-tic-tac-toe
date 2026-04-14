package Models;

import Exceptions.Exception;
import Models.Enums.CellState;
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

    public Game(int size, List<Player> players,
                List<WinningStrategy> winningStrategies) {
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>(); // Initially no moves
        this.nextPlayerIdx = 0; // Index of first player in the List
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
    }

    public void makeMove(){
        // The next player will make the move
        Player currentPlayer = players.get(nextPlayerIdx);

        // The current player plays a move on the board
        Move move = currentPlayer.makeMove(board);

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cell = board.getCells().get(row).get(col);
        // Set the current player to that particular Cell
        if(cell.getCellState().equals(CellState.FILLED)){
            throw new Exception.BlockedCellException("This cell is already filled");
        }

            cell.setPlayer(currentPlayer);
            cell.setCellState(CellState.FILLED);


        // Add the move to list of moves to track state.
        moves.add(move);

        // Initialize the next player
        nextPlayerIdx = (nextPlayerIdx + 1) % players.size();

        // Check if the current player's move makes him a winner.
        if(isWinner(move)){
            this.winner = currentPlayer;
            this.gameState = GameState.ENDED;
        }else if(moves.size() == board.getSize()* board.getSize()){
            this.gameState = GameState.DRAW;
        }
    }


    public boolean isWinner(Move move){

        for(WinningStrategy win : winningStrategies){
            if(win.hasWon(move))
                return true;
        }
        return false;
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

    public static Builder getBuilder(){
        return new Builder();
    }


    public static class Builder{
        int boardSize;
        List<Player> players;
        List<WinningStrategy> winningStrategies;

        public Builder setSize(int boardSize){
            this.boardSize = boardSize;
            return this;
        }

        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies){
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build(){
            return new Game(boardSize,players,winningStrategies);
        }

    }
}
