package Models;

import Models.Enums.PlayerType;

public abstract class Player {
    private int playerId;
    private String playerName;
    private Symbol symbol;
    private PlayerType playerType;



    public Player(int playerId, String playerName, Symbol symbol, PlayerType playerType) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
