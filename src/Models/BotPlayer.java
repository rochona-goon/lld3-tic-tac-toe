package Models;

import Models.Enums.DifficultyLevel;
import Models.Enums.PlayerType;

public class BotPlayer extends Player{

    private DifficultyLevel difficultyLevel;
    public BotPlayer(int playerId, String playerName, Symbol symbol, DifficultyLevel difficultyLevel) {
        super(playerId, playerName, symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
