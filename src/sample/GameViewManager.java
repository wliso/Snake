package sample;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.effect.*;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Stop;
import javafx.application.Platform;
import javax.swing.text.View;
import javax.xml.validation.SchemaFactoryConfigurationError;
import java.io.Console;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;

public class GameViewManager {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;

    private static final int NUMBER_OF_SQUARES = 30;

    private List<Segment> objects = new ArrayList<Segment>();
    private Stage menuStage;
    private Snake snake;

    private SmallInfoLabel pointsLabel;
    private int points = 0;
    private Wall wall;
    private Board board;
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
                if (event.getCode() == KeyCode.SPACE ){

                }
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
       // pointsLabel = new SmallInfoLabel("POINTS: 00");
        //pointsLabel.setLayoutX(460);
        //pointsLabel.setLayoutY(0);
        //gamePane.getChildren().add(pointsLabel);

        createWall();
        createSnake();
        createFood();
        CreateGameLoop();
        gameStage.show();
    }

    private void CreateGameLoop(){
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveSnake();
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e){}
            }
        };
        gameTimer.start();
    }

    private void createWall(){
        board = new Board();
        board.AddWall();
        gamePane.getChildren().addAll(board.fromListWallToListNode());
    }
    private void createSnake(){
        snake = new Snake();
        gamePane.getChildren().add(this.snake.head.getNode());
        snake.addBody();
        snake.addBody();
        gamePane.getChildren().addAll(snake.fromListBodyToListNode());
        objects.addAll(snake.nodes);
    }

    private void createFood(){
        Food food = new Food();
        double x,y;
        do{
            Random rand = new Random();
            x = (double)rand.nextInt(NUMBER_OF_SQUARES)*GAME_WIDTH/NUMBER_OF_SQUARES;
            y = (double)rand.nextInt(NUMBER_OF_SQUARES)*GAME_HEIGHT/NUMBER_OF_SQUARES;
        }while(!isEmpty(x,y));
        food.getNode().setLayoutX(x);
        food.getNode().setLayoutY(y);
        gamePane.getChildren().add(food.getNode());
        objects.add(food);
    }

    private void moveSnake(){

        if(wspPom.equals(WspPom.RIGHT)){
            snake.setDirection(Head.Direction.RIGHT);
        }
        if (wspPom.equals(WspPom.LEFT)){
            snake.setDirection(Head.Direction.LEFT);
        }
        if (wspPom.equals(WspPom.UP)){
            snake.setDirection(Head.Direction.UP);
        }
        if (wspPom.equals(WspPom.DOWN)){
            snake.setDirection(Head.Direction.DOWN);
        }
        collision(snake.head.getNode().getLayoutX(),snake.head.getNode().getLayoutY());
    }
    
    boolean isEmpty(double x, double y){
        for (int i=0;i<objects.size();i++) {
            if(objects.get(i).getNode().getLayoutX() == x && objects.get(i).getNode().getLayoutY() == y){
                if(objects.get(i).getid() != "head"){
                return false;
                }
            }
        }
        return true;
    }
    Segment whatType(double x, double y){
        for (int i=0;i<objects.size();i++) {
            if(objects.get(i).getNode().getLayoutX() == x && objects.get(i).getNode().getLayoutY() == y) {
                switch (objects.get(i).getid()) {
                    case "body":
                        return new Body(x,y);
                    case "wall":
                        return new Wall(x, y);
                    case "food":
                        return new Food();
                }
            }
        }
        return null;
    }


    public void collision(double x,double y){
        if(!isEmpty(x,y)){
            Segment seg = whatType(x,y);
            switch (seg.getid()){
                case "food":
                    collisionFood();
                    break;
                case "body":
                    collisionBody();
                    break;
                case "wall":
                    collisionWall();
                    break;
            }
        }
    }
    public int returnScore(){
        int score = snake.segments.size();
        return score;
    }
    public void gameOver(){
        gamePane.getChildren().clear();

        StackPane root = new StackPane();
        Text text = new Text(" GAME OVER \n\n" + "YOUR SCORE:"+points+"\n\n RERUN YOUR APP TO GAME AGAIN");
        text.setTextAlignment(TextAlignment.CENTER);
        Button button = new Button("My Button");
        //root.getChildren().addAll((Collection<? extends Node>) button);
        root.getChildren().add(text);
        root.setStyle("-fx-font-size: 16pt;\n" +
                "    -fx-font-family: \"Courier New\";\n" +
                "    -fx-base: rgb(132, 145, 47);\n" +
                "    -fx-background: red;");
        StackPane.setAlignment(text, Pos.CENTER);
        Scene scene = new Scene(root, 600, 600);
        gameStage.setScene(scene);
        gameStage.show();

    }

    private void collisionBody(){
        gameOver();
    }
    private void collisionWall(){
        gameOver();
    }


    private void collisionFood(){
        deleteFood();
        snake.addBody();
        gamePane.getChildren().add(snake.segments.get(snake.segments.size()-1).getNode());
        objects.add(snake.segments.get(snake.segments.size()-1));
      //  points++;
      //  String textToSet = "POINTS : ";
       // if(points <10){
      //      textToSet = textToSet + "0";
     //   }
     //   pointsLabel.setText(textToSet + points);
        createFood();
    }



    private void deleteFood(){
        try{
            for (Segment seg: objects) {
                if(seg.getid().equals("food")) {
                    gamePane.getChildren().get(gamePane.getChildren().indexOf(seg.getNode())).setVisible(false);
                    objects.remove(seg);
                }
            }
        } catch(ConcurrentModificationException e){
            //System.out.println(e.getMessage());
        }
    }

}