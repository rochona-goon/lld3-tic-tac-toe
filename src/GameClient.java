import Controller.GameController;
import Models.Enums.GameState;
import Models.Game;

public class GameClient{
    static void main(String[] args) {
        GameController gameController = new GameController();
        Game game = gameController.startGame();
    }
}
