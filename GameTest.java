import org.junit.Test;

import javax.sound.sampled.Clip;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Create new inst of Game Class
 * call winner method with different inputs
 * checks expected output vs actual output
 * assertEquals() comes from JUnit
 */
public class GameTest {
    @Test
    public void testWinner() {
        Game game = new Game();
        assertEquals(0, game.winner(1, 1)); // tie - rock vs rock
        assertEquals(-1, game.winner(1, 2)); // player 2 wins - rock vs paper
        assertEquals(1, game.winner(3, 2)); // player 1 wins again - paper vs scissors
        assertEquals(0, game.winner(3, 3)); // tie - scissors vs scissors
    }


    @Test
    public void testPlay() {

    }

    @Test
    public void testSelectGameMode() {

    }

    @Test
    public void testPlayWinSound() {
        Game game = new Game();
        game.playWinSound();
        Clip clip = game.getClip();
        assertTrue(clip.isRunning(), "The sound clip should be running");
    }
}



