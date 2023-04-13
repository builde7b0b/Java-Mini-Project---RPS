import java.util.Random;

public class Computer extends Player{
    private String name;

    public Computer(String name){
        super(name);

    }

    public int choose() {
        Random random = new Random();
        return random.nextInt(3) + 1;


    }

    public String getName() {
        return name;

    }



    public void getChoice() {

    }
}
