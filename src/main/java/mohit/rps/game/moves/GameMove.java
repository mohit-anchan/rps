package mohit.rps.game.moves;

import java.util.Arrays;

/**
 *
 */
public enum GameMove {
    ROCK("R"),
    PAPER("P"),
    SCISSOR("S");

    private String initial;

    private GameMove(String initial) {
        this.initial = initial;
    }

    public static GameMove getMoveByInitial(String initial) {
        return Arrays.stream(values())
                .filter(m -> m.initial.equalsIgnoreCase(initial))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
