package mohit.rps.game.gesture;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Rock extends Gesture {
    private static final List<Gesture> beats = Arrays.asList(new Scissor());

    @Override
    public String getInitial() {
        return "R";
    }

    @Override
    public List<Gesture> getBeats() {
        return beats;
    }

}
