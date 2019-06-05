package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ViewManager {
private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private final static int MENU_BUTTONS_START_X = 100;
    private final static int MENU_BUTTONS_START_Y = 150;

    private SnakeSubscene scoresSubscene;
    private SnakeSubscene settingsSubscene;
    private SnakeSubscene sceneToHide;

    List<SnakeButton> menuButtons;

    public ViewManager(){
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,WIDTH,HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createSubScenes();
        createButtons();
        createBackground();
        createLogo();

    }

    private void showSubScene(SnakeSubscene subScene){
        if(sceneToHide != null){
            sceneToHide.moveSubScene();
        }
        subScene.moveSubScene();
        sceneToHide = subScene;
    }

    private void createSubScenes(){
        scoresSubscene = new SnakeSubscene();
        mainPane.getChildren().add(scoresSubscene);

        settingsSubscene = new SnakeSubscene();
        mainPane.getChildren().add(settingsSubscene);
    }

    public Stage getMainStage(){
        return mainStage;
    }

    private void addMenuButton(SnakeButton button){
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    private void createButtons(){
        createStartButton();
        createScoresButton();
        settingsButton();
        createExitButton();
    }

    public void createStartButton(){
        SnakeButton startButton = new SnakeButton("PLAY");
        addMenuButton(startButton);

        startButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
                    public void handle(ActionEvent event){
                GameViewManager gameManager = new GameViewManager();
                gameManager.createNewGame(mainStage);
            }
        });
    }

    public void createScoresButton(){
        SnakeButton scoresButton = new SnakeButton("SCORES");
        addMenuButton(scoresButton);

        scoresButton.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                showSubScene(scoresSubscene);
            }
        });
    }

    private void settingsButton(){
        SnakeButton settingsButton = new SnakeButton("SETTINGS");
        addMenuButton(settingsButton);

        settingsButton.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                showSubScene(settingsSubscene);
            }
        });
    }

    private void createExitButton(){
        SnakeButton exitButton = new SnakeButton("EXIT");
        addMenuButton(exitButton);

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.close();
            }
        });
    }

    public void createBackground(){
        Image backgroundImage = new Image("resources/background-elements-redux/Backgrounds/backgroundColorDesert.png",WIDTH,HEIGHT,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        mainPane.setBackground(new Background(background));
    }

    private void createLogo(){
        ImageView logo = new ImageView("resources/logo.png");
        logo.setFitHeight(180);
        logo.setFitWidth(180);
        logo.setLayoutX(400);
        logo.setLayoutY(10);

        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(new DropShadow());
            }
        });

        logo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(null);
            }
        });
        mainPane.getChildren().add(logo);
    }
}
