package mohit.rps.game.gesture;

import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by Mohit.
 */
public class Paper extends Gesture {
    private static final List<Gesture> beats = Arrays.asList(new Rock(), new Spock());

    @Override
    public String getShortCode() {
        return "P";
    }

    @Override
    public List<Gesture> getBeats() {
        return beats;
    }
}
