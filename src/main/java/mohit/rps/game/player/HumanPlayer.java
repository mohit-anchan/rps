package mohit.rps.game.player;

import mohit.rps.game.moves.GameMove;

import java.util.Scanner;

/**
 *
 */
public class HumanPlayer extends Player {

    private Scanner input = new Scanner(System.in);

//    public HumanPlayer(Scanner input) {
//        this.input = input;
//    }

    @Override
    public void makeMove() {
        String userInput = fetchUserInput();
        this.move = GameMove.getMoveByInitial(userInput);
    }

    private String fetchUserInput() {
        String accStr;
        System.out.println("Make your move by pressing one of below characters: ");
        System.out.println(" R for Rock");
        System.out.println(" P for Paper");
        System.out.println(" S for Scissor");

        accStr = input.next();
        return accStr;
    }
}
