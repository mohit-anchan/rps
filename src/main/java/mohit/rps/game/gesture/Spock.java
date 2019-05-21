package mohit.rps.game.gesture;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mohit on 21-May-19.
 */
public class Spock extends Gesture {
    private static final List<Gesture> beats = Arrays.asList(new Scissor(), new Rock());

    @Override
    public String getShortCode() {
        return "K";
    }

    @Override
    public List<Gesture> getBeats() {
        return beats;
    }
}
