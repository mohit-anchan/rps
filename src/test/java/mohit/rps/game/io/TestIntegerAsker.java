package mohit.rps.game.io;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TestIntegerAsker {
    PrintStream out;

    @Before
    public void init(){
        out = Mockito.mock(PrintStream.class);
    }

    @Test
    public void test_correct_input_recorded(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        IntegerAsker asker = new IntegerAsker(in, out);

        assertEquals(asker.ask("Press 1"), 1);
    }
}
