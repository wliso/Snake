package sample;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Head extends Segment {

    private Node node;
    public String getid(){
        return "head";
    }
    public Node getNode(){
        return node;
    }
    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;
    private static final int NUMBER_OF_SQUARES = 30;

    private String HEADS_URL = "resources/pixeluipack/9-Slice/Colored/green_pressed.png";

    Head(){
        node = new ImageView(HEADS_URL);
        ((ImageView) node).setFitWidth(GAME_WIDTH/NUMBER_OF_SQUARES);
        ((ImageView) node).setFitHeight(GAME_HEIGHT/NUMBER_OF_SQUARES);
        node.setLayoutX(GAME_WIDTH/2);
        node.setLayoutY(GAME_HEIGHT/2);
        node.setId("head");
    }

    public void moveHead(){
        if(direction.equals(Direction.RIGHT)){
            node.setLayoutX(node.getLayoutX()+GAME_WIDTH/NUMBER_OF_SQUARES);
        }
        if(direction.equals(Direction.LEFT)){
            node.setLayoutX(node.getLayoutX()-GAME_WIDTH/NUMBER_OF_SQUARES);
        }
        if(direction.equals(Direction.UP)){
            node.setLayoutY(node.getLayoutY()-GAME_HEIGHT/NUMBER_OF_SQUARES);
        }
        if(direction.equals(Direction.DOWN)){
            node.setLayoutY(node.getLayoutY()+GAME_HEIGHT/NUMBER_OF_SQUARES);
        }
    }

    void eat(Food food){}
}
