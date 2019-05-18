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
                return new Game(new HumanPlayer(), new AIPlayer(), rules);
            case AI_VS_AI:
                return new Game(new AIPlayer(), new AIPlayer(), rules);
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
        System.out.println("Player1 plays "+player1.getMove());
        System.out.println("Player2 plays "+player2.getMove());
    }

    public void printResult(){
        String resultMsg = (this.result == Result.Draw)
                ? "Its a Draw"
                : this.result.toString() + " is the winner";

        System.out.println("===================================");
        System.out.println(resultMsg);
        System.out.println("===================================");
    }

    public Result getResult() {
        return result;
    }
}
