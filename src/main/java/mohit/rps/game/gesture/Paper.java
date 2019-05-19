package mohit.rps.game.gesture;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Paper extends Gesture {
    private static final List<Gesture> beats = Arrays.asList(new Rock());

    @Override
    public String getInitial() {
        return "P";
    }

    @Override
    public List<Gesture> getBeats() {
        return beats;
    }


}
