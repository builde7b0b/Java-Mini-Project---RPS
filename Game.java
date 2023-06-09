import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Game implements GameInterface {

    // we don't need many interfaces if any for now
// added interface for Game class to improve encapsulation

    private HumanPlayer player1;
    private Player player2;

    private Scanner scanner; // inst var, get user input from the console.
    //Scanner class lets us read input from many sources
    private ArrayList<String> history;

    private Clip clip;

    public Game() {
        scanner = new Scanner(System.in);
        history = new ArrayList<String>();
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

            String resultString = String.format("%s chose %s and %s chose %s", player1.getName(), choiceToString(choice1),
                    player2.getName(), choiceToString(choice2));
            history.add(resultString);

            System.out.print(resultString);


            int result = winner(choice1, choice2);

            if (result == 0) {
                System.out.println("It's a tie!");

            } else if (result == 1) {
                System.out.printf("%s wins!%n", player1.getName());
                playWinSound();
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

    public void displayHistory() {
        System.out.println("Game History:");
        for (String resultString : history) {
            System.out.println(resultString);
        }
    }

    @Override
    public void winner() {

    }


    private int selectGameMode() {
        //handle invalid input and exceptions

        //select game mode - create method
        System.out.println("Please Select Game mode:");
        System.out.println("1. Two Players");
        System.out.println("2. Player vs Computer");
        // inst var for gamemode
        int gameMode = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                gameMode = scanner.nextInt();
                scanner.nextLine();
                if (gameMode == 1 || gameMode == 2) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number");
                scanner.nextLine();
            }
        }
//    scanner.nextLine();
        return gameMode;
    }


    //create method to convert the choice input to a string
    // its represented as an int
    private String choiceToString(int choice) {
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
                choice1 == 3 && choice2 == 2) {
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


    //create method to play sound
    public void playWinSound() {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("laugh.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            System.err.println("Unsupported audio file format: " + e.getMessage());
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.err.println("Line unavailable: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading audio file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unknown error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Clip getClip() {
        return clip;
    }

}



