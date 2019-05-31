package sample;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class GameViewManager {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;

    private static final int NUMBER_OF_SQUARES = 30;

    private Stage menuStage;
    private Snake snake;

    public GameViewManager(){
        initializeStage();
        createKeyListeners();
    }

    private void createKeyListeners(){
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.LEFT){

                } else if (event.getCode() == KeyCode.RIGHT){

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

    public void createNewGame(Stage menuStage, Snake snake){
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
        gamePane.getChildren().add(snake.head.head);
        gameStage.show();

    }
}