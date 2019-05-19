package mohit.rps.game.factory;

import mohit.rps.game.Game;
import mohit.rps.game.player.Player;
import mohit.rps.game.player.strategies.AIPlayerStrategy;
import mohit.rps.game.player.strategies.HumanPlayerStrategy;
import mohit.rps.game.player.strategies.PlayStrategy;
import mohit.rps.game.rules.GameEngine;

/**
 *
 */
public class GameFactory {
    /* Game Modes */
    public static final int PLAYER_VS_AI = 1;
    public static final int AI_VS_AI = 2;
    public static final int EXIT_GAME = 3;

    public static Game createGame(int gameMode, GameEngine engine) {
        PlayStrategy aiStrategy = new AIPlayerStrategy(engine.getValidGestures());
        PlayStrategy humanStrategy = new HumanPlayerStrategy(engine.getValidGestures(), System.in, System.out);

        switch (gameMode) {
            case PLAYER_VS_AI:
                return new Game(
                        new Player("User", humanStrategy),
                        new Player("Computer", aiStrategy),
                        engine
                );
            case AI_VS_AI:
                return new Game(
                        new Player("Computer1", aiStrategy),
                        new Player("Computer2", aiStrategy),
                        engine
                );
            case EXIT_GAME:
                System.out.println("Thank you for playing! Exiting game....");
                System.exit(0);
            default:
                throw new IllegalArgumentException("Invalid game mode "+gameMode);
        }
    }
}
