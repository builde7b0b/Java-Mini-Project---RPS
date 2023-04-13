import javax.sound.sampled.Clip;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
//        game.play();
        game.playWinSound();
        Clip clip = game.getClip();
//        game.displayHistory();
    }


}
