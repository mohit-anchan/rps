package mohit.rps.game.rule;

import mohit.rps.game.Result;
import mohit.rps.game.moves.GameMove;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TestGameRules {

    GameRules rules;

    @Before
    public void init(){
        rules = new RPSGameRules();
    }

    @Test
    public void test_rock_rock_gives_draw(){
        Result result = rules.compareMoves(GameMove.ROCK, GameMove.ROCK);
        assertEquals(result, Result.Draw);
    }

    @Test
    public void test_rock_beats_scissor(){
        Result result = rules.compareMoves(GameMove.ROCK, GameMove.SCISSOR);
        assertEquals(result, Result.Player1);
    }

    @Test
    public void test_scissor_beats_paper(){
        Result result = rules.compareMoves(GameMove.SCISSOR, GameMove.PAPER);
        assertEquals(result, Result.Player1);
    }

    @Test
    public void test_paper_beats_rock(){
        Result result = rules.compareMoves(GameMove.ROCK, GameMove.PAPER);
        assertEquals(result, Result.Player2);
    }
}
