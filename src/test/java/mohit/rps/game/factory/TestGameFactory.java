package mohit.rps.game.factory;

import mohit.rps.game.Game;
import mohit.rps.game.player.strategies.AIPlayerStrategy;
import mohit.rps.game.player.strategies.HumanPlayerStrategy;
import mohit.rps.game.rules.RPSGameEngine;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

/**
 *
 */
public class TestGameFactory {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_human_vs_ai_game(){
        Game game = GameFactory.createGame(GameFactory.PLAYER_VS_AI, new RPSGameEngine());

        assertTrue(game.getPlayer1().getPlayStrategy() instanceof HumanPlayerStrategy);
        assertTrue(game.getPlayer2().getPlayStrategy() instanceof AIPlayerStrategy);
    }

    @Test
    public void test_ai_vs_ai_game(){
        Game game = GameFactory.createGame(GameFactory.AI_VS_AI, new RPSGameEngine());

        assertTrue(game.getPlayer1().getPlayStrategy() instanceof AIPlayerStrategy);
        assertTrue(game.getPlayer2().getPlayStrategy() instanceof AIPlayerStrategy);
    }

    @Test
    public void test_incorrect_mode_throws_exception(){
        int incorrectGameMode = 4;

        expectedException.expect(IllegalArgumentException.class);
        Game game = GameFactory.createGame(incorrectGameMode, new RPSGameEngine());
    }
}
