/**
 * Creates and manages the paddle object
 *
 * @author Justin Lusby
 * @date 5/16/19
 */
package ballBounce;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * Creates the paddle object
 */
public class Paddle extends Rectangle{
    private Rectangle paddle;

    public Paddle() {
        this.paddle = new Rectangle(50, 20, Color.ORANGE);
        this.paddle.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                movePaddle(event.getX(), 0);
            }
        });
        //resetPaddle();
    }

    /**
     * Resets the paddle to the middle of the start bar
     * if one of the reset buttons are pushed
     */
    public void resetPaddle(){
    }

    /**
     * Moves the paddle along the paddle bar as the mouse is moved
     * across the play area.  Moves only in the horizontal direction.
     * @param dx : direction to move along the x axis
     */
    public void movePaddle(double dx, double dy){
        paddle.setLayoutX(paddle.getLayoutX() + dx);
    }
}
