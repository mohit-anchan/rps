package mohit.rps.game.rule;

import mohit.rps.game.Result;
import mohit.rps.game.moves.GameMoveConfig;
import mohit.rps.game.moves.GameMove;

import java.util.List;

/**
 * Created by mohit on 18-May-19.
 */
public abstract class GameRules {

    abstract List<GameMoveConfig> getValidMoves();

    public Result getResult(GameMove player1Move, GameMove player2Move){
        if (player1Move == player2Move) {
            return Result.Draw;
        }

        if (loadMoveConfig(player1Move)
                .winsAgainst(loadMoveConfig(player2Move))) {
            return Result.Player1;
        }

        return Result.Player2;
    }

    public GameMoveConfig loadMoveConfig(GameMove moveName){
        return getValidMoves().stream()
                .filter(m -> m.getName() == moveName)
                .findAny()
                .orElseThrow(() -> new RuntimeException(moveName.toString() + " is not a legal move."));
    }
}
