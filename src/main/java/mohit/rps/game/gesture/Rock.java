package mohit.rps.game.gesture;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mohit.
 */
public class Rock extends Gesture {
    private static final List<Gesture> beats = Arrays.asList(new Scissor());

    @Override
    public String getShortCode() {
        return "R";
    }

    @Override
    public List<Gesture> getBeats() {
        return beats;
    }

}
