package mohit.rps.game.strategies;

import mohit.rps.game.gesture.Gesture;
import mohit.rps.game.gesture.Paper;
import mohit.rps.game.gesture.Rock;
import mohit.rps.game.gesture.Scissor;
import mohit.rps.game.player.strategies.HumanPlayerStrategy;
import mohit.rps.game.player.strategies.PlayStrategy;
import mohit.rps.game.rules.RPSGameEngine;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mohit
 */
public class TestHumanPlayerStrategy {
    List<Gesture> gestures;
    PrintStream out;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Before
    public void init(){
        gestures = RPSGameEngine.validGestures;
        out = Mockito.mock(PrintStream.class);
    }

    @Test
    public void test_pressing_r_returns_rock(){
        String userInput = "R";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());

        PlayStrategy strategy = new HumanPlayerStrategy(gestures, in, out);
        assertEquals(strategy.getMove().getClass(), Rock.class);
    }

    @Test
    public void test_pressing_s_returns_scissor(){
        String userInput = "S";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());

        PlayStrategy strategy = new HumanPlayerStrategy(gestures, in, out);
        assertEquals(strategy.getMove().getClass(), Scissor.class);
    }

    @Test
    public void test_pressing_p_returns_paper(){
        String userInput = "P";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());

        PlayStrategy strategy = new HumanPlayerStrategy(gestures, in, out);
        assertEquals(strategy.getMove().getClass(), Paper.class);
    }

    @Test
    public void test_pressing_incorrect_shortcode_throws_exception(){
        String incorrectUserInput = "Z";
        ByteArrayInputStream in = new ByteArrayInputStream(incorrectUserInput.getBytes());

        expectedException.expect(IllegalArgumentException.class);
        PlayStrategy strategy = new HumanPlayerStrategy(gestures, in, out);
        strategy.getMove();
    }
}
