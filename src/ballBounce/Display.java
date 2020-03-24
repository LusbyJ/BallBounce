package ballBounce;
/**
 * Creates and manages the display for the GUI
 *
 * @author Justin Lusby
 * @date 5/9/19
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Display extends Application {
    private BorderPane display = new BorderPane();
    private GridPane playArea;
    private ArrayList<Brick> bricks;
    private static Label scoreLabel;
    private static Label levelLabel;
    public static int boardWidth = 600;
    public static int boardHeight = 700;

    /**
     * Creates the play area and fills it with bricks
     *
     * @return display
     */
    public BorderPane createBoard() {
        playArea = new GridPane();
        display.setPrefSize(boardWidth, boardHeight);
        //Brick.shuffleBricks();
        int increment = 0;
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 30; y++) {
                playArea.add(Brick.getBrick(increment), x, y);
                increment++;
            }
        }
        display.setTop(playArea);
        return display;
    }

    /**
     * Creates the play area with bricks
     *
     * @return
     */
    public void createBricks() {
        bricks = new ArrayList<>();
        for (int x = 0; x < 900; x++) {
            if (x != 0 && (900 % x == 0 || 900 % x == 1)) {
                new Brick(Color.YELLOW);
            } else {
                new Brick(Color.BLUE);
            }
        }
    }

    /**
     * Creates the slider for the paddle to move along
     */
    public void createPaddle() {
        HBox slider = new HBox();
        Paddle paddle = new Paddle();
        slider.getChildren().add(paddle);
        paddle.relocate(0, 300);
        slider.setPrefSize(boardWidth, 30);
//        slider.setStyle("-fx-background-color: blue");
        display.setCenter(slider);
    }

    /**
     * Creates the controls for the game along with a display
     * for the current score and level
     */
    public void createControls() {
        HBox controls = new HBox();
        controls.setStyle("-fx-background-color: black");
        controls.setPrefHeight(40);
        Button startButton = new Button("Start");
        createStyle(startButton);
        Button resetLevelButton = new Button("Reset Level");
        createStyle(resetLevelButton);
        Button resetGameButton = new Button("Reset Game");
        createStyle(resetGameButton);
        createScoreLabel();
        createLevelLabel();
        controls.getChildren().addAll(startButton, scoreLabel, resetLevelButton, resetGameButton, levelLabel);
        display.setBottom(controls);
    }

    /**
     * Set the style for the button passed to it
     * css styling taken from
     * "http://fxexperience.com/2011/12/styling-fx-buttons-with-css/"
     *
     * @param button to be stylized
     */
    public static void createStyle(Button button) {
        button.setStyle(" -fx-padding: 8 15 15 15; " +
                "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0; " +
                "-fx-background-radius: 8; " +
                "-fx-background-color: linear-gradient(from 0% 93% to 0% 100%" +
                ", #a34313 0%, #903b12 100%),#9d4024,#d86e3a, radial-gradient(" +
                "center 50% 50%, radius 100%, #d86e3a, #c54e2c); " +
                "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 ); " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 1.1em;");
        button.setPrefWidth(150);
    }

    /**
     * Creates the score label
     */
    public static void createScoreLabel() {
        scoreLabel = new Label();
        scoreLabel.setPrefWidth(100);
        scoreLabel.setTextFill(Color.WHITE);
        scoreLabel.setText("Score\n00");
    }

    /**
     * Creates the label to display the current game level
     */
    public static void createLevelLabel() {
        levelLabel = new Label();
        levelLabel.setPrefWidth(100);
        levelLabel.setTextFill(Color.WHITE);
        levelLabel.setText("Level:\n1");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        createBoard();
        createPaddle();
        createControls();
        display.getChildren().add(new Ball().createBall());
        primaryStage.setTitle("Ball Buster");
        primaryStage.setScene(new Scene(display, boardWidth, boardHeight));
        primaryStage.show();
        Manager.playGame();
    }

    /**
     * Entry point, launches the program GUI
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        int i;
        FileInputStream input;
        if (args.length != 1) {
            System.out.println("Please specify a input board config file");
            return;
        }

        try {
            input = new FileInputStream(args[0]);
        } catch (FileNotFoundException exc) {
            System.out.println("File Not Found");
            return;
        }
        try {
            //read until EOF
            do {
                i = input.read();
                if (i != -1) {
                    if (i == 49) {
                        new Brick(Color.YELLOW);
                    } else {
                        new Brick(Color.BLUE);
                    }
                }
            } while (i != -1);
            launch(args);
        } catch (IOException exc) {
            System.out.println("Error Reading File.");
        }

        try {
            input.close();
        } catch (IOException exc) {
            System.out.println("Error Closing file");
        }
    }
}
//
//        else{
//            FileReader fr =
//                    new FileReader("level1.txt");
//            int i;
//            while ((i=fr.read()) != -1){
//                if(i == 49){
//                    new Brick(Color.YELLOW);
//                }
//                if(i == 48) {
//                    new Brick(Color.BLUE);
//                }
//            }
//            launch(args);
//        }
//    }
//}
