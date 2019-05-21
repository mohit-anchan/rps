package mohit.rps.game.rules;

import mohit.rps.game.Result;
import mohit.rps.game.gesture.Gesture;
import mohit.rps.game.gesture.Paper;
import mohit.rps.game.gesture.Rock;
import mohit.rps.game.gesture.Scissor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * This class is the game engine for the Rock Paper Scissor game.
 *
 * Created by Mohit.
 */
public class RPSGameEngine extends GameEngine {
    /**
     * Holds the list of valid gestures that a user is allowed to play.
     */
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

    /**
     *
     * @return Returns an immutable list consisting of all valid moves
     */
    private static List<Gesture> initializeGestures() {
        return Stream.of(
                new Rock(),
                new Paper(),
                new Scissor()
        ).collect(collectingAndThen(toList(),
                Collections::unmodifiableList));
    }

}
