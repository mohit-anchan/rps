package mohit.rps.game.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TestStringAsker {

    @Test
     public void test_correct_input_recorded(){
        ByteArrayInputStream in = new ByteArrayInputStream("Y".getBytes());
        StringAsker asker = new StringAsker(in, System.out);

        assertEquals(asker.ask("Enter Y/N"), "Y");
    }

}
