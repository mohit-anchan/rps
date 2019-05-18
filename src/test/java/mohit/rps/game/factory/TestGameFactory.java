package mohit.rps.game.factory;

import mohit.rps.game.Game;
import mohit.rps.game.player.AIPlayer;
import mohit.rps.game.player.HumanPlayer;
import mohit.rps.game.rule.RPSGameRules;
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
        Game game = GameFactory.createGame(GameFactory.PLAYER_VS_AI, new RPSGameRules());

        assertTrue(game.getPlayer1() instanceof HumanPlayer);
        assertTrue(game.getPlayer2() instanceof AIPlayer);
    }

    @Test
    public void test_ai_vs_ai_game(){
        Game game = GameFactory.createGame(GameFactory.AI_VS_AI, new RPSGameRules());

        assertTrue(game.getPlayer1() instanceof AIPlayer);
        assertTrue(game.getPlayer2() instanceof AIPlayer);
    }

    @Test
    public void test_incorrect_mode_throws_exception(){
        int incorrectGameMode = 3;

        expectedException.expect(IllegalArgumentException.class);
        Game game = GameFactory.createGame(incorrectGameMode, new RPSGameRules());
    }
}
