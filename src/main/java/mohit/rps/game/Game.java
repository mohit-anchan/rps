package mohit.rps.game;

import mohit.rps.game.player.Player;
import mohit.rps.game.rules.GameEngine;

/**
 * The main class that maintains the state of the game.
 *
 * Created by Mohit.
 */
public class Game {
    private GameEngine engine;

    private Player player1;
    private Player player2;

    private Result result;

    public Game(Player player1, Player player2, GameEngine ge) {
        this.player1 = player1;
        this.player2 = player2;
        this.engine = ge;
    }

    public void start() {
        player1.play();
        player2.play();
        this.result = engine.compareMoves(player1.getMove(), player2.getMove());
    }

    public void printResult(){
        System.out.println(player1.getName() + " plays "+player1.getMove().getName());
        System.out.println(player2.getName() + " plays "+player2.getMove().getName());

        System.out.println("===================================");
        System.out.println(getResultMessage());
        System.out.println("===================================");
    }

    private String getResultMessage(){
        if (this.result == Result.DRAW) {
            return "Its a Draw";
        }

        if (this.result == Result.PLAYER1_WINS) {
            return this.player1.getMove().getName() + " beats " + this.player2.getMove().getName()
                    + "\n" + this.player1.getName() + " is the winner";
        }

        return this.player2.getMove().getName() + " beats " + this.player1.getMove().getName()
                + "\n" + this.player2.getName() + " is the winner";
    }

    public Result getResult() {
        return result;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
