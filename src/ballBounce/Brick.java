/**
 * Creates the and manages the brick object
 *
 * @author Justin Lusby
 * @date 5/16/19
 */
package ballBounce;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * Creates the brick object
 */
public class Brick {
    private Rectangle brick;
    private static ArrayList<Rectangle> bricks = new ArrayList<>();
    private int width = 20;
    private int height = 20;
    /**
     * Constructor for a brick object.
     *Creates a new Rectangle and sets its color.
     * @param color : color to set this brick as
     */
    public Brick(Color color){
        this.brick = new Rectangle(width, height, color);
        if(color == Color.YELLOW) {
            this.brick.setStroke(Color.BLACK);
        }
        else{
            this.brick.setStroke(Color.BLUE);
        }
        bricks.add(brick);
    }

    /**
     * Gets a the brick from the specified index from the bricks array lis
     * @param index : index position of desired brick
     */
    public static Rectangle getBrick(int index) {
        return bricks.get(index);
    }
}
