package mohit.rps.game;

import mohit.rps.game.player.AIPlayer;
import mohit.rps.game.player.HumanPlayer;
import mohit.rps.game.player.Player;
import mohit.rps.game.rule.GameRules;
import mohit.rps.game.rule.RPSGameRules;

/**
 *
 */
public class Game {
    private GameRules rules;

    private Player player1;
    private Player player2;

    private Result result;

    /* Game Modes */
    public static final int PLAYER_VS_AI = 1;
    public static final int AI_VS_AI = 2;

    public Game(Player player1, Player player2, GameRules rules) {
        this.player1 = player1;
        this.player2 = player2;
        this.rules = rules;
    }

    public static Game bootstrapGame(int gameMode, GameRules rules) {
        switch (gameMode) {
            case PLAYER_VS_AI:
                return new Game(new HumanPlayer("User"), new AIPlayer("Computer"), rules);
            case AI_VS_AI:
                return new Game(new AIPlayer("Computer1"), new AIPlayer("Computer2"), rules);
            default:
                throw new IllegalArgumentException();
        }
    }

    public void start() {
        player1.makeMove();
        player2.makeMove();

        printMoves();

        result = rules.compareMoves(player1.getMove(), player2.getMove());
    }

    private void printMoves(){
        System.out.println(player1.getName() + " plays "+player1.getMove());
        System.out.println(player2.getName() + " plays "+player2.getMove());
    }

    public void printResult(){
        System.out.println("===================================");
        System.out.println(getResultMessage());
        System.out.println("===================================");
    }

    private String getResultMessage(){
        if (this.result == Result.Draw) {
            return "Its a Draw";
        }

        if (this.result == Result.Player1) {
            return this.player1.getMove() + " beats " + this.player2.getMove()
                    + "\n" + this.player1.getName() + " is the winner";
        }

        return this.player2.getMove() + " beats " + this.player1.getMove()
                + "\n" + this.player2.getName() + " is the winner";
    }

    public Result getResult() {
        return result;
    }
}
