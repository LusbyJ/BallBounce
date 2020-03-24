/**
 * Creates the ball object
 *
 * @author Justin Lusby
 * @date 5/9/19
 */
package ballBounce;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
    public static final int RADIUS = 10;
    private static Circle ball = new Circle();

    /**
     * Relocates the ball to the bottom of the play area
     */
    public void resetBall()
    {
        ball.relocate(Display.boardWidth/2, Display.boardHeight - 90);
    }

    /**
     * Creates the ball object, sets the radius, and color
     * @return ball
     */
    public Circle createBall(){
        ball.setRadius(RADIUS);
        ball.setFill(Color.ORANGERED);
        resetBall();
        return ball;
    }
    /**
     * Moves the ball on the game board while playing
     * @param dx units to move along the x-axis
     * @param dy units to move along the y-axis
     */
    public void moveBall(double dx, double dy){
        ball.setLayoutX(ball.getLayoutX() + dx);
        ball.setLayoutY(ball.getLayoutY() + dy);
    }

    /**
     * Method to return the y position of the ball
     * @return layoutY
     */
    public static double getY(){
        return ball.getLayoutY();
    }

    /**
     * Method to return the x position of the ball
     * @return layoutX
     */
    public static double getX(){
        return ball.getLayoutX();
    }
}

