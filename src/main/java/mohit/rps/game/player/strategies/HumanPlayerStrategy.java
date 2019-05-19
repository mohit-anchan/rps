package mohit.rps.game.player.strategies;

import mohit.rps.game.gesture.Gesture;
import mohit.rps.game.io.StringAsker;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

/**
 *
 */
public class HumanPlayerStrategy implements PlayStrategy {

    private List<Gesture> validGestures;
    private StringAsker asker;

    public HumanPlayerStrategy(List<Gesture> validGestures, InputStream in, PrintStream out) {
        this.validGestures = validGestures;
        this.asker = new StringAsker(in, out);
    }

    @Override
    public Gesture getMove() {
        String userInput = fetchUserInput();
        return validGestures.stream()
                .filter(m -> m.getInitial().equalsIgnoreCase(userInput))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private String fetchUserInput() {
        StringBuilder message = new StringBuilder("Make your move by pressing one of below characters: ");
        for (Gesture gesture : validGestures) {
            /* This prints as "R for Rock" */
            message.append("\n" + gesture.getInitial() + " for " + gesture.getName());
        }
        return asker.ask(message.toString());
    }
}
