package mohit.rps.game.rules;

import mohit.rps.game.Result;
import mohit.rps.game.gesture.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * Created by mohit on 21-May-19.
 */
public class RPSLSGameEngine extends GameEngine {
    public static final List<Gesture> validGestures = initializeGestures();

    @Override
    public List<Gesture> getValidGestures() {
        return validGestures;
    }

    /**
     * Compares the moves played by both the users and returns the outcome.
     * @param player1Move
     * @param player2Move
     * @return
     */
    @Override
    public Result compareMoves(Gesture player1Move, Gesture player2Move) {
        if (player1Move.equals(player2Move)) {
            return Result.DRAW;
        }

        if (player1Move.winsAgainst(player2Move)) {
            return Result.PLAYER1_WINS;
        }

        return Result.PLAYER2_WINS;
    }

    private static List<Gesture> initializeGestures() {
        return Stream.of(
                new Rock(),
                new Paper(),
                new Scissor(),
                new Lizard(),
                new Spock()
        ).collect(collectingAndThen(toList(),
                Collections::unmodifiableList));
    }

}
