package sample;

import javafx.animation.AnimationTimer;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.List;

import static sample.GameViewManager.WspPom.*;

public class GameViewManager {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;

    private static final int NUMBER_OF_SQUARES = 30;

    private Stage menuStage;
    private Snake snake;

    private boolean isLeftPressed;
    private boolean isRightPressed;
    private boolean isUpPressed;
    private boolean isDownPressed;
    public enum WspPom {
        RIGHT, LEFT, UP,DOWN,NONE;
    }
    WspPom wspPom = WspPom.NONE;
    private AnimationTimer gameTimer;

    public GameViewManager(){
        initializeStage();
        createKeyListeners();
    }

    private void createKeyListeners(){
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.LEFT) {
                        wspPom = WspPom.LEFT;
                    } else if (event.getCode() == KeyCode.RIGHT) {
                        wspPom = WspPom.RIGHT;
                    } else if (event.getCode() == KeyCode.UP) {
                        wspPom = WspPom.UP;
                    } else if (event.getCode() == KeyCode.DOWN) {
                        wspPom = WspPom.DOWN;
                    }
            }
        });

        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.LEFT){

                } else if (event.getCode() == KeyCode.RIGHT){

                }
            }
        });
    }

    private void initializeStage(){
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane,GAME_WIDTH,GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
    }

    public void createNewGame(Stage menuStage){
        this.menuStage = menuStage;
        this.menuStage.hide();
        for(int i=1;i<NUMBER_OF_SQUARES;i++){
            Line line = new Line(GAME_WIDTH/NUMBER_OF_SQUARES*i,0,GAME_WIDTH/NUMBER_OF_SQUARES*i,GAME_HEIGHT);
            Line line2 = new Line(0,GAME_HEIGHT/NUMBER_OF_SQUARES*i,GAME_WIDTH,GAME_HEIGHT/NUMBER_OF_SQUARES*i);
            line.setStrokeWidth(0.5);
            line2.setStrokeWidth(0.5);
            gamePane.getChildren().add(line);
            gamePane.getChildren().add(line2);
        }
        createSnake();

        CreateGameLoop();
        gameStage.show();
    }

    private void CreateGameLoop(){
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveSnake();
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e){}
            }
        };
        gameTimer.start();
    }

    private void createSnake(){
        snake = new Snake();
        gamePane.getChildren().add(this.snake.head.head);
        snake.addBody();
        snake.addBody();
        gamePane.getChildren().addAll(snake.fromListBodyToListNode());
    }

    private void moveSnake(){

        if(wspPom.equals(WspPom.RIGHT)){
            //snake.head.head.setLayoutX(snake.head.head.getLayoutX()+GAME_WIDTH/NUMBER_OF_SQUARES);
            snake.setDirection(Head.Direction.RIGHT);
        }
        if (wspPom.equals(WspPom.LEFT)){
            //snake.head.head.setLayoutX(snake.head.head.getLayoutX()-GAME_WIDTH/NUMBER_OF_SQUARES);
            snake.setDirection(Head.Direction.LEFT);
        }
        if (wspPom.equals(WspPom.UP)){
            //snake.head.head.setLayoutY(snake.head.head.getLayoutY()-GAME_HEIGHT/NUMBER_OF_SQUARES);
            snake.setDirection(Head.Direction.UP);
        }
        if (wspPom.equals(WspPom.DOWN)){
            //snake.head.head.setLayoutY(snake.head.head.getLayoutY()+GAME_HEIGHT/NUMBER_OF_SQUARES);
            snake.setDirection(Head.Direction.DOWN);
        }
    }


}