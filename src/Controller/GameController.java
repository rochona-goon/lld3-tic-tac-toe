package Controller;

import Exceptions.Exception;
import Models.Board;
import Models.Enums.GameState;
import Models.Game;
import Models.Move;
import Models.Player;
import Strategies.WinningStrategy;
import Validators.Validator;

import java.util.List;
import java.util.Scanner;

public class GameController {
    GameState gameState;
    Scanner sc = new Scanner(System.in);


    public Game startGame(int size, List<Player> players, List<WinningStrategy> winningStrategies){

        return Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }

    public void display(Game game){
        game.getBoard().display();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public int getBoardSize(){
        System.out.println("Enter Board size: ");
        int boardSize = sc.nextInt();

        if(!Validator.checkBoardSize(boardSize))
            throw new Exception.InvalidBoardException("Please enter a valid board size.");

        return boardSize;
    }
}
