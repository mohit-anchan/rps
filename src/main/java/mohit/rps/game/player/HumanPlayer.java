package mohit.rps.game.player;

import mohit.rps.game.moves.GameMove;

import java.util.Scanner;

/**
 *
 */
public class HumanPlayer extends Player {

    private Scanner input = new Scanner(System.in);

    @Override
    public void makeMove() {
        String userInput = fetchUserInput();
        this.move = GameMove.getMoveByInitial(userInput);
    }

    private String fetchUserInput() {
        String accStr;
        System.out.println("Make your move by pressing one of below characters: ");
        for (GameMove move : GameMove.values()) {
            /* This prints as "R for Rock" */
            System.out.println(move.getInitial() + " for "+ move.name());
        }

        accStr = input.next();
        return accStr;
    }
}
