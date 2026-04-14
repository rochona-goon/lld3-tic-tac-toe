package Models;

import Models.Enums.PlayerType;

import java.util.Scanner;

public class HumanPlayer extends Player{

    private int age;
    private Scanner sc = new Scanner(System.in);

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


    @Override
    public Move makeMove(Board board) {

        // User input
        System.out.println(this.getPlayerName()+", enter row and column: ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        return new Move(this, new Cell(row,col));
    }
}
