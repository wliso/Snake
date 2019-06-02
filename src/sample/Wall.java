package sample;

import javafx.scene.Node;

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

    private String WALL_URL = "resources/pixeluipack/9-Slice/Colored/grey_pressed.png";
}
