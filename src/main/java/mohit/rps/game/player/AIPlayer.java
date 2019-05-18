package mohit.rps.game.player;

import mohit.rps.game.moves.GameMove;

import java.util.Random;

/**
 *
 */
public class AIPlayer extends Player {

    private static final Random RANDOM = new Random();

    @Override
    public void makeMove() {
        /* Get a random value out of enum */
        int randomInt = RANDOM.nextInt(GameMove.values().length);
        this.move = GameMove.values()[randomInt];
    }
}
