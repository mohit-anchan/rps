package mohit.rps.game.player.strategies;

import mohit.rps.game.gesture.Gesture;
import mohit.rps.game.io.StringAsker;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * Strategy for the Human player to make his/her move.
 *
 * Created by Mohit.
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
                .filter(m -> m.getShortCode().equalsIgnoreCase(userInput))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Lists down all the valid moves to the user and prompts him to make his move by entering a Gesture's short code.
     * @return
     */
    private String fetchUserInput() {
        StringBuilder message = new StringBuilder("Make your move by pressing one of below characters: ");
        for (Gesture gesture : validGestures) {
            /* This prints as "R for Rock" */
            message.append("\n" + gesture.getShortCode() + " for " + gesture.getName());
        }
        return asker.ask(message.toString());
    }
}
