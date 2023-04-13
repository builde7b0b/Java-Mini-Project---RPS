import java.util.Scanner;

public class HumanPlayer extends Player {
        private Scanner scanner;
        private String name;
        public int choose() {
                //prompt user for choice
                System.out.println("Enter 1 for rock, 2 for paper, and 3 for scissors");
                int choice = scanner.nextInt();

                while (choice < 1 || choice > 3) {
                        System.out.println("Invalid choice. Please enter a valid option");
                        choice = scanner.nextInt();
                }
                return choice;

        }

        public String getName() {
                return name;

        }


        public void getChoice() {

        }
}

