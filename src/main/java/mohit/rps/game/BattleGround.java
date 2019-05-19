package mohit.rps.game;

import mohit.rps.game.factory.GameFactory;
import mohit.rps.game.io.IntegerAsker;
import mohit.rps.game.rules.RPSGameEngine;

import java.util.InputMismatchException;

/**
 *
 */
public class BattleGround {
    public static void main(String[] args) {
        new BattleGround().begin();
    }

    public void begin() {
        while (true) {
            int gameMode = getGameModeFromUser();

            try {
                Game game = GameFactory.createGame(gameMode, new RPSGameEngine());
                game.start();
                game.printResult();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input! Please try again");
                continue;
            }
        }
    }

    public int getGameModeFromUser() {
        int userInput = 0;

        while (userInput == 0) {
            String message = "Please select mode: \n" +
                    "Press 1 for Player vs Computer \n" +
                    "Press 2 for Computer vs Computer \n" +
                    "Press 3 to exit game";

            try {
                userInput = new IntegerAsker(System.in, System.out).ask(message);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again");
                continue;
            }
            break;
        }
        return userInput;
    }
}
