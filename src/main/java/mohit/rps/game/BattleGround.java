package mohit.rps.game;

import java.util.Scanner;

/**
 *
 */
public class BattleGround {
    public static void main(String[] args) {

        try (Scanner in = new Scanner((System.in))) {
            while (true) {
                int gameMode = getGameModeFromUser(in);

                try {
                    Game game = Game.bootstrapGame(gameMode);
                    game.start();
                    game.printResult();
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input! Please try again");
                    continue;
                }

                if (playAgain(in)) {
                    continue;
                }
                break;
            }
        }
    }

    public static int getGameModeFromUser(Scanner in) {
        int userInput = 0;

        while (userInput == 0) {
            System.out.println("Please select mode: \n" +
                    "Press 1 for Player vs Computer \n" +
                    "Press 2 for Computer vs Computer");

            try {
                userInput = Integer.parseInt(in.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please try again");
                continue;
            }
            break;
        }
        return userInput;
    }

    public static boolean playAgain(Scanner in) {
        System.out.println("\n Play again? Y/N ");
        if ("Y".equalsIgnoreCase(in.next())) {
            return true;
        }
        System.out.println("Thank you for playing!");
        return false;
    }
}
