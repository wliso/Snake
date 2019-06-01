package sample;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Head extends Segment {

    public Node head;
    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;
    private static final int NUMBER_OF_SQUARES = 30;

    private String HEADS_URL = "resources/pixeluipack/9-Slice/Colored/green_pressed.png";

    Head(){
        head = new ImageView(HEADS_URL);
        ((ImageView) head).setFitWidth(GAME_WIDTH/NUMBER_OF_SQUARES);
        ((ImageView) head).setFitHeight(GAME_HEIGHT/NUMBER_OF_SQUARES);
        head.setLayoutX(GAME_WIDTH/2);
        head.setLayoutY(GAME_HEIGHT/2);
    }

    public void moveHead(){
        if(direction.equals(Direction.RIGHT)){
            head.setLayoutX(head.getLayoutX()+GAME_WIDTH/NUMBER_OF_SQUARES);
        }
        if(direction.equals(Direction.LEFT)){
            head.setLayoutX(head.getLayoutX()-GAME_WIDTH/NUMBER_OF_SQUARES);
        }
        if(direction.equals(Direction.UP)){
            head.setLayoutY(head.getLayoutY()-GAME_HEIGHT/NUMBER_OF_SQUARES);
        }
        if(direction.equals(Direction.DOWN)){
            head.setLayoutY(head.getLayoutY()+GAME_HEIGHT/NUMBER_OF_SQUARES);
        }
    }

    void eat(Food food){}
}
