import java.util.Scanner;

public class Game implements GameInterface {

    // we don't need many interfaces if any for now
// added interface for Game class to improve encapsulation

    private HumanPlayer player1;
    private Player player2;

    private Scanner scanner; // inst var, get user input from the console.
    //Scanner class lets us read input from many sources


    public Game() {
        scanner = new Scanner(System.in);
        // System.in is an InputStream
        // set to keyboard by default
        // create a new scanner to read from the keyboard essentially
    }

public void play() {

        // welcome message
    System.out.println("Welcome to Rock-Paper-Scissors!");

    //prompt user to enter name for player 1
    System.out.println("Enter name for Player 1:");
    String player1Name = scanner.nextLine();
    player1 = new HumanPlayer(player1Name);

    // init var to get selected Game Mode
    int gameMode = selectGameMode();

    //conditionals to check which game mode is chosen
    if (gameMode == 1) {
        System.out.println("Enter name for Player 2:");
        String player2Name = scanner.nextLine();
        player2 = new HumanPlayer(player2Name);

    } else {

        player2 = new Computer("Computer");
    }
    System.out.println(player2.getName());

    while (true) {
        int choice1 = player1.choose();
        int choice2 = player2.choose();

        System.out.printf("%s chose %s%n", player1.getName(), choiceToString(choice1));
        if (player2 instanceof Computer) {
            System.out.printf("%s chose %s%n", player2.getName(), choiceToString(choice2));
        } else {
            System.out.printf("%s chose %s%n", player2.getName());
        }



        int result = winner(choice1, choice2);

        if (result == 0) {
            System.out.println("It's a tie!");

        } else if (result == 1) {
            System.out.printf("%s wins!%n", player1.getName());
        } else {
            System.out.printf("%s wins! %n", player2.getName());
        }

        if (!playAgain()) {
            break;
        }



    }

    scanner.close();


        // player vs player
        // OR
         //player vs computer
    //Game Logic to Determine Choices and Winners
    // some sort of loop
    // player1 choice =
    // player2 choice =
    // print choices
    // check Results -
    // determine winners
        //conditional statements
        // if both players choose the same choice
            // tie
        // else if player one has the winning symbol
            // print winner
        // else
            // print the other player won
    //reset game


}

    @Override
    public void winner() {

    }


    private int selectGameMode() {
    //select game mode - create method
    System.out.println("Please Select Game mode:");
    System.out.println("1. Two Players");
    System.out.println("2. Player vs Computer");
    // inst var for gamemode
    int gameMode = scanner.nextInt();
    scanner.nextLine();
    return gameMode;
}


//create method to convert the choice input to a string
    // its represented as an int
private String choiceToString(int choice){
        switch (choice) {
            case 1:
                return "rock";
            case 2:
                return "paper";
            case 3:
                return "scissors";
            default:
                return "";
        }
}

    @Override
public int winner(int choice1, int choice2) {
        if (choice1 == choice2) {
            return 0; //Tie
        } else if (choice1 == 1 && choice2 == 3 ||
                choice1 == 2 && choice2 == 1 ||
                choice1 == 3 && choice2 == 2){
            return 1; // player 1 wins
        } else {
            return -1; //  player 2 wins
        }



}

private boolean playAgain() {
        System.out.println("Play again? (y/n)");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y");
}


}
