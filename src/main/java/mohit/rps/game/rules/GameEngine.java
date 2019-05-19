package mohit.rps.game.rules;

import mohit.rps.game.Result;
import mohit.rps.game.gesture.Gesture;

import java.util.List;

/**
 *
 */
public abstract class GameEngine {

    public abstract List<Gesture> getValidGestures();

    public abstract Result compareMoves(Gesture player1Move, Gesture player2Move);
}
