package mohit.rps.game.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TestIntegerAsker {

    @Test
    public void test_correct_input_recorded(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        IntegerAsker asker = new IntegerAsker(in, System.out);

        assertEquals(asker.ask("Press 1"), 1);
    }
}
