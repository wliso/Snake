package sample;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.geom.Point2D;

public class Food extends Segment {
    public String getid(){
        return "food";
    }
    public Node getNode(){
        return node;
    }
    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;

    private static final int NUMBER_OF_SQUARES = 30;
    private String FOOD_URL = "resources/cherry-icon.png";

    private Node node;

    public Food(){
        node = new ImageView(FOOD_URL);
        ((ImageView) node).setFitWidth(GAME_WIDTH/NUMBER_OF_SQUARES);
        ((ImageView) node).setFitHeight(GAME_HEIGHT/NUMBER_OF_SQUARES);
        node.setId("food");
    }

}
