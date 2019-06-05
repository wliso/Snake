package sample;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Wall extends Segment {

    private Node node;
    public String getid(){
        return "wall";
    }
    public Node getNode(){
        return node;
    }
    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;
    private static final int NUMBER_OF_SQUARES = 30;

    private String WALL_URL = "resources/pixeluipack/9-Slice/Colored/green_pressed.png";
    Wall(double x, double y){
        node = new ImageView(WALL_URL);
        ((ImageView) node).setFitWidth(GAME_WIDTH/NUMBER_OF_SQUARES);
        ((ImageView) node).setFitHeight(GAME_HEIGHT/NUMBER_OF_SQUARES);
        node.setLayoutX(x);
        node.setLayoutY(y);
        node.setId("wall");
    }
}
