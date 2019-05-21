package mohit.rps.game.gesture;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mohit on 21-May-19.
 */
public class Lizard extends Gesture {
    private static final List<Gesture> beats = Arrays.asList(new Paper(), new Spock());
    @Override
    public String getShortCode() {
        return "L";
    }

    @Override
    public List<Gesture> getBeats() {
        return beats;
    }
}
