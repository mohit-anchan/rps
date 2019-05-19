package mohit.rps.game.gesture;

import java.util.List;

/**
 *
 */
public abstract class Gesture {

    public String getName() {
        return getClass().getSimpleName();
    }

    public abstract String getInitial();

    public abstract List<Gesture> getBeats();

    public boolean winsAgainst(Gesture gesture) {
        return getBeats().contains(gesture);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }

        if (getClass() == o.getClass()) {
            return true;
        }
        return false;
    }
}
