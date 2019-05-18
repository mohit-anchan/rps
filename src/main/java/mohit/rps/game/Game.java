package mohit.rps.game;

import mohit.rps.game.moves.GameMoveConfig;
import mohit.rps.game.moves.GameMove;
import mohit.rps.game.player.AIPlayer;
import mohit.rps.game.player.HumanPlayer;
import mohit.rps.game.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class Game {
    private Player player1;
    private Player player2;

    private Result result;

    /* Game Modes */
    public static final int PLAYER_VS_AI = 1;
    public static final int AI_VS_AI = 2;

    private static List<GameMoveConfig> moves;
    static {
        initializeMoves();
    }

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public static Game bootstrapGame(int gameMode) {
        switch (gameMode) {
            case PLAYER_VS_AI:
                return new Game(new HumanPlayer(), new AIPlayer());
            case AI_VS_AI:
                return new Game(new AIPlayer(), new AIPlayer());
            default:
                throw new IllegalArgumentException();
        }
    }

    private static void initializeMoves() {
        moves = Stream.of(
                    new GameMoveConfig(GameMove.ROCK, Arrays.asList(GameMove.SCISSOR)),
                    new GameMoveConfig(GameMove.PAPER, Arrays.asList(GameMove.ROCK)),
                    new GameMoveConfig(GameMove.SCISSOR, Arrays.asList(GameMove.PAPER))
                )
                .collect(Collectors.toList());
    }

    public void start() {
        player1.makeMove();
        player2.makeMove();

        printMoves();

        compareMoves();
    }

    private void printMoves(){
        System.out.println("Player1 plays "+player1.getMove());
        System.out.println("Player2 plays "+player2.getMove());
    }

    private void compareMoves() {
        if (isDraw()) {
            result = Result.Draw;
            return;
        }

        //TODO: remove call to getGameMove here
        if (getGameMove(player1.getMove()).winsAgainst(getGameMove(player2.getMove()))) {
            result = Result.Player1;
            return;
        }

        result = Result.Player2;
    }

    private boolean isDraw(){
        return player1.getMove().equals(player2.getMove());
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

    public static GameMoveConfig getGameMove(GameMove moveName){
        return moves.stream()
                .filter(m -> m.getName() == moveName)
                .findAny()
                .orElseThrow(() -> new RuntimeException(moveName.toString() + " is not a legal move."));
    }

}
