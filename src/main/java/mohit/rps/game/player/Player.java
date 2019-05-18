package mohit.rps.game.player;

import mohit.rps.game.moves.GameMove;

/**
 *
 */
public abstract class Player {

    protected GameMove move;

    protected String name;

    public abstract void makeMove();

    public GameMove getMove() {
        return this.move;
    }

    public String getName() {
        return name;
    }
}
