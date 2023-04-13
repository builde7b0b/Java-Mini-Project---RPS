import java.util.Scanner;

public class Game implements GameInterface {

    // we don't need many interfaces if any for now
// added interface for Game class to improve encapsulation

    private Player player1;
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


private int SelectGameMode() {
    //select game mode - create method
    System.out.println("Please Select Game mode:");
    System.out.println("1. Two Players");
    System.out.println("2. Player vs Computer");
    // inst var for gamemode
    int gameMode = scanner.nextInt();
    scanner.nextLine();
    return gameMode;
}


public void winner() {

}


}
