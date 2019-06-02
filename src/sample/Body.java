package sample;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Body extends Segment{
    private Node node;
    public String getid(){
        return "body";
    }
    public Node getNode(){
        return node;
    }
    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;
    private static final int NUMBER_OF_SQUARES = 30;

    private String BODY_URL = "resources/pixeluipack/9-Slice/Colored/green_pressed.png";

    Body(double x,double y){
        node = new ImageView(BODY_URL);
        ((ImageView) node).setFitWidth(GAME_WIDTH/NUMBER_OF_SQUARES);
        ((ImageView) node).setFitHeight(GAME_HEIGHT/NUMBER_OF_SQUARES);
        node.setLayoutX(x);
        node.setLayoutY(y);
        node.setId("body");
    }
    public void moveSegment(){
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
}
