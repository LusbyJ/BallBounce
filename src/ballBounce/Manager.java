/**
 * Main game loop for the program.
 *
 * @author Justin Lusby
 * @date 5/16/19
 */
package ballBounce;
import javafx.animation.AnimationTimer;

public class Manager {
    private static int dx = 1;
    private static int dy = -3;
    private static long time = 10_000_000;  // determines speed of animation
    private static long lastUpdate = 0;
    /**
     * Main game loop for the game. Moves the ball around in the play area
     */
    public static void playGame() {
        AnimationTimer a = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= time) {
                    lastUpdate = now;
                    new Ball().moveBall(dx, dy);

                    //check if ball hits x axis border
                    if (Ball.getX() >= Display.boardWidth - Ball.RADIUS || Ball.getX() <= Ball.RADIUS) {
                        dx = -dx;
                    }

                    //check if ball hits y axis border
                    if (Ball.getY() > Display.boardHeight - 70 || Ball.getY() <= Ball.RADIUS) {
                        dy = -dy;
                    }

                }
            }
        };
        a.start();
    }
}