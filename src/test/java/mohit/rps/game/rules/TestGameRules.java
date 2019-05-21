package mohit.rps.game.rules;

import mohit.rps.game.Result;
import mohit.rps.game.gesture.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TestGameRules {

    GameEngine rules;

    @Before
    public void init(){
        rules = new RPSGameEngine();
    }

    @Test
    public void test_rock_rock_gives_draw(){
        Result result = rules.compareMoves(new Rock(), new Rock());
        assertEquals(result, Result.DRAW);
    }

    @Test
    public void test_rock_beats_scissor(){
        Result result = rules.compareMoves(new Rock(), new Scissor());
        assertEquals(result, Result.PLAYER1_WINS);
    }

    @Test
    public void test_scissor_beats_paper(){
        Result result = rules.compareMoves(new Scissor(), new Paper());
        assertEquals(result, Result.PLAYER1_WINS);
    }

    @Test
    public void test_paper_beats_rock(){
        Result result = rules.compareMoves(new Rock(), new Paper());
        assertEquals(result, Result.PLAYER2_WINS);
    }

    @Test
    public void test_spock_beats_scissor(){
        Result result = rules.compareMoves(new Scissor(), new Spock());
        assertEquals(result, Result.PLAYER2_WINS);
    }

    @Test
    public void test_spock_beats_rock(){
        Result result = rules.compareMoves(new Rock(), new Spock());
        assertEquals(result, Result.PLAYER2_WINS);
    }

    @Test
    public void test_lizard_beats_spock(){
        Result result = rules.compareMoves(new Lizard(), new Spock());
        assertEquals(result, Result.PLAYER1_WINS);
    }

    @Test
    public void test_lizard_beats_paper(){
        Result result = rules.compareMoves(new Lizard(), new Paper());
        assertEquals(result, Result.PLAYER1_WINS);
    }
}
