import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {
        private Scanner scanner;
        private String name;

        public HumanPlayer(String name) {
                super(name);
                scanner = new Scanner(System.in);
                this.name = name;

                // set to keyboard by default
                // create a new scanner to read from the keyboard essentially
        }
        public int choose() {
                //prompt user for choice
                System.out.println("Enter 1 for rock, 2 for paper, and 3 for scissors");
                int choice = 0;
                boolean validInput = false;
                while (!validInput) {
                        try {
                                choice = scanner.nextInt();
                                while (choice < 1 || choice > 3) {
                                        System.out.println("Invalid choice. Please enter a valid option");
                                        choice = scanner.nextInt();
                                }
                                validInput = true;
                        } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a number");
                                scanner.nextLine();
                        }
                }
                return choice;

        }

        public String getName() {
                return name;

        }


        public void getChoice() {

        }
}

