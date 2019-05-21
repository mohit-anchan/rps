package mohit.rps.game.gesture;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mohit.
 */
public class Scissor extends Gesture {
    private static final List<Gesture> beats = Arrays.asList(new Paper(), new Lizard());

    @Override
    public String getShortCode() {
        return "S";
    }

    @Override
    public List<Gesture> getBeats() {
        return beats;
    }

}
