package mohit.rps.game.moves;

import java.util.List;

/**
 *
 */
public class GameMoveConfig {

    private GameMove name;
    private List<GameMove> beats;

    public GameMoveConfig(GameMove name, List<GameMove> beats) {
        this.name = name;
        this.beats = beats;
    }

    public boolean winsAgainst(GameMoveConfig gameMove){
        return this.beats.contains(gameMove.getName());
    }

    public GameMove getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GameMoveConfig gameMove = (GameMoveConfig) o;

        return name.equals(gameMove.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
