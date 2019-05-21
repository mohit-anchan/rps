package mohit.rps.game.player.strategies;

import mohit.rps.game.gesture.Gesture;

/**
 * Base for strategies that can be implemented by different kinds of players.
 *
 * Created by Mohit.
 */
public interface PlayStrategy {

    public Gesture getMove();
}
