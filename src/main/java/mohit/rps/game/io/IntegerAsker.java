package mohit.rps.game.io;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Helper class for fetching a integer input from the user.
 */
public class IntegerAsker {
    private final Scanner scanner;
    private final PrintStream out;

    public IntegerAsker(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public int ask(String message) {
        out.println(message);
        return scanner.nextInt();
    }
}
