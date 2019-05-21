package mohit.rps.game.player.strategies;

import mohit.rps.game.gesture.Gesture;

import java.util.List;
import java.util.Random;

/**
 * Strategy for the Computer to make its move. Here, it just returns a random move.
 *
 * Created by Mohit.
 */
public class AIPlayerStrategy implements PlayStrategy {
    private List<Gesture> validGestures;

    private static final Random RANDOM = new Random();

    public AIPlayerStrategy(List<Gesture> validGestures) {
        this.validGestures = validGestures;
    }

    @Override
    public Gesture getMove() {
        int randomInt = RANDOM.nextInt(validGestures.size());
        return validGestures.get(randomInt);
    }
}
