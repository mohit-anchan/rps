package mohit.rps.game.gesture;

import java.util.List;

/**
 * The class represents a playable gesture. All
 * the valid gestures in the Game (Rock,Paper,etc), are
 * implemented as instances of this class.
 *
 * Created by Mohit.
 */
public abstract class Gesture {

    public String getName() {
        return getClass().getSimpleName();
    }

    /**
     * A (single letter) code that is unique to the current Gesture.
     * To play this gesture, user can just input this short code instead of typing the entire name.
     */
    public abstract String getShortCode();

    /**
     * List of Gestures that the current Gesture defeats.
     */
    public abstract List<Gesture> getBeats();

    public boolean winsAgainst(Gesture gesture) {
        return getBeats().contains(gesture);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (getClass() == o.getClass()) {
            return true;
        }
        return false;
    }
}
