package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class SnakeSubscene extends SubScene {

    private final static String FONT_PATH = "resources/menu/kenvector_future_thin.ttf";
    private final static String BACKGROUD_IMAGE = "resources/uipack_fixed/PNG/green_panel.png";

    private boolean isHidden = true;

    public SnakeSubscene() {
        super(new AnchorPane(), 400, 300);
        prefWidth(400);
        prefHeight(300);
        BackgroundImage image = new BackgroundImage(new Image(BACKGROUD_IMAGE,400,300,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(image));

        setLayoutX(1024);
        setLayoutY(190);
    }

    public void moveSubScene(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);
        if(isHidden){
            transition.setToX(-700);
            isHidden = false;
        } else {
            transition.setToX(0);
            isHidden = true;
        }

        transition.play();
    }
}
