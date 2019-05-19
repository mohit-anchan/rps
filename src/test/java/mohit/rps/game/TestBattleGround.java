package mohit.rps.game;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by mohit
 */
public class TestBattleGround {
    PrintStream out;

    @Before
    public void init(){
        out = Mockito.mock(PrintStream.class);
    }

    @Test
     public void test_valid_user_input(){
        BattleGround bg = new BattleGround();
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());

        assertEquals(bg.getGameModeFromUser(in, out), 1);
    }
}
