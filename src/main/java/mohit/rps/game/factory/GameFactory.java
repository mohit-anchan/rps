package mohit.rps.game.factory;

import mohit.rps.game.Game;
import mohit.rps.game.player.AIPlayer;
import mohit.rps.game.player.HumanPlayer;
import mohit.rps.game.rule.GameRules;

/**
 *
 */
public class GameFactory {
    /* Game Modes */
    public static final int PLAYER_VS_AI = 1;
    public static final int AI_VS_AI = 2;

    public static Game createGame(int gameMode, GameRules rules) {
        switch (gameMode) {
            case PLAYER_VS_AI:
                return new Game(new HumanPlayer("User"), new AIPlayer("Computer"), rules);
            case AI_VS_AI:
                return new Game(new AIPlayer("Computer1"), new AIPlayer("Computer2"), rules);
            default:
                throw new IllegalArgumentException("Invalid game mode "+gameMode);
        }
    }
}
