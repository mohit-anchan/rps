package mohit.rps.game.rule;

import mohit.rps.game.moves.GameMoveConfig;
import mohit.rps.game.moves.GameMove;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class RPSLSGameRules extends GameRules {
    private static List<GameMoveConfig> validMoves;

    static {
        initializeMoves();
    }

    private static void initializeMoves() {
        validMoves = Stream.of(
                new GameMoveConfig(GameMove.ROCK, Arrays.asList(GameMove.SCISSOR)),
                new GameMoveConfig(GameMove.PAPER, Arrays.asList(GameMove.ROCK)),
                new GameMoveConfig(GameMove.SCISSOR, Arrays.asList(GameMove.PAPER))
        ).collect(Collectors.toList());
    }

    @Override
    List<GameMoveConfig> getValidMoves() {
        return validMoves;
    }
}
