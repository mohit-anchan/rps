package mohit.rps.game.gesture;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Scissor extends Gesture {
    private static final List<Gesture> beats = Arrays.asList(new Paper());

    @Override
    public String getInitial() {
        return "S";
    }

    @Override
    public List<Gesture> getBeats() {
        return beats;
    }

}
