package mohit.rps.game.io;

import mohit.rps.game.gesture.Gesture;
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
 *
 */
public class TestStringAsker {
    PrintStream out;

    @Before
    public void init(){
        out = Mockito.mock(PrintStream.class);
    }

    @Test
     public void test_correct_input_recorded(){
        ByteArrayInputStream in = new ByteArrayInputStream("Y".getBytes());
        StringAsker asker = new StringAsker(in, out);

        assertEquals(asker.ask("Enter Y/N"), "Y");
    }

}
