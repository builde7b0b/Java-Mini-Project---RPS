import java.util.Scanner;

public class Game implements GameInterface {

    // we don't need many interfaces if any for now
// added interface for Game class to improve encapsulation

    private Player player1;
    private Player player2;
    private Scanner scanner; // get user input from the console.
    //Scanner class lets us read input from many sources


    public Game() {
        scanner = new Scanner(System.in);
    }
    
public void play() {


}

public void winner() {

}


}
