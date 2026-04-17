package Strategies;

import Models.Enums.DifficultyLevel;

public class BotStrategyFactory {
    public static BotStrategy createStrategy(DifficultyLevel difficultyLevel){
        if(difficultyLevel.equals(DifficultyLevel.EASY))
            return new EasyBotStrategy();
        else if(difficultyLevel.equals(DifficultyLevel.MEDIUM))
            return new MediumBotStrategy();
        else
            return new HardBotStrategy();
    }
}
