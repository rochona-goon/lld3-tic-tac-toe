package Models;

import Models.Enums.PlayerType;

public class HumanPlayer extends Player{

    private int age;
    public HumanPlayer(int playerId, String playerName, Symbol symbol, int age) {
        super(playerId, playerName, symbol, PlayerType.HUMAN);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
