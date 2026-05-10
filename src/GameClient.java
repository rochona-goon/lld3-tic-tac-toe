import Controller.GameController;
import Models.*;
import Models.Enums.DifficultyLevel;
import Models.Enums.GameState;
import Strategies.WinningStrategy;
import Strategies.columnWinningStrategy;
import Strategies.diagonalWinningStrategy;
import Strategies.rowWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameClient{
    static void main(String[] args) {
        GameController gameController = new GameController();

        int boardSize = gameController.getBoardSize();
        List<Player> playerList = new ArrayList<>();
        playerList.add(new HumanPlayer(7,"Player_!", new Symbol("X"), 28));
        playerList.add(new BotPlayer(2, "BOT", new Symbol("O"), DifficultyLevel.MEDIUM));


        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new rowWinningStrategy(boardSize));
        winningStrategies.add(new columnWinningStrategy(boardSize));
        winningStrategies.add(new diagonalWinningStrategy(boardSize));


        Game game = gameController.startGame(boardSize,playerList, winningStrategies);


        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            // display board
            gameController.display(game);

            // makeMove
            gameController.makeMove(game);

            // hasWon()
            if(gameController.getGameState(game).equals(GameState.ENDED)){
                Player winner = gameController.getWinner(game);
                gameController.display(game);
                System.out.println("***** "+winner.getPlayerName()+" is the winner!! *****");

            }else if(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
                continue;
            }else{
                gameController.display(game);
                System.out.println("It's a draw (-_-)");

            }
        }
    }
}
