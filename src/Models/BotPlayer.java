package Models;

import Models.Enums.DifficultyLevel;
import Models.Enums.PlayerType;
import Strategies.BotStrategy;
import Strategies.BotStrategyFactory;

public class BotPlayer extends Player{

    private DifficultyLevel difficultyLevel;
    private BotStrategy botStrategy;
    public BotPlayer(int playerId, String playerName, Symbol symbol, DifficultyLevel difficultyLevel) {
        super(playerId, playerName, symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
        this.botStrategy = BotStrategyFactory.createStrategy(difficultyLevel);
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Bot's turn ...");
        return botStrategy.makeMove(board,this);
    }

}
