package mohit.rps.game.player;

import mohit.rps.game.gesture.Gesture;
import mohit.rps.game.player.strategies.PlayStrategy;

/**
 *
 */
public class Player {

    private String name;

    private Gesture move;

    private PlayStrategy playStrategy;

    public Player(String name, PlayStrategy playStrategy) {
        this.name = name;
        this.playStrategy = playStrategy;
    }

    public void play() {
        this.move = playStrategy.getMove();
    }

    public Gesture getMove() {
        return this.move;
    }

    public String getName() {
        return this.name;
    }

    public PlayStrategy getPlayStrategy() {
        return playStrategy;
    }
}
