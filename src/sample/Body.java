package sample;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Body extends Segment{
    public Node body;
    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;
    private static final int NUMBER_OF_SQUARES = 30;

    private String BODY_URL = "resources/pixeluipack/9-Slice/Colored/green_pressed.png";

    Body(double x,double y){
        body = new ImageView(BODY_URL);
        ((ImageView) body).setFitWidth(GAME_WIDTH/NUMBER_OF_SQUARES);
        ((ImageView) body).setFitHeight(GAME_HEIGHT/NUMBER_OF_SQUARES);
        body.setLayoutX(x);
        body.setLayoutY(y);
    }
    public void moveSegment(){
        if(direction.equals(Direction.RIGHT)){
            body.setLayoutX(body.getLayoutX()+GAME_WIDTH/NUMBER_OF_SQUARES);
        }
        if(direction.equals(Direction.LEFT)){
            body.setLayoutX(body.getLayoutX()-GAME_WIDTH/NUMBER_OF_SQUARES);
        }
        if(direction.equals(Direction.UP)){
            body.setLayoutY(body.getLayoutY()-GAME_HEIGHT/NUMBER_OF_SQUARES);
        }
        if(direction.equals(Direction.DOWN)){
            body.setLayoutY(body.getLayoutY()+GAME_HEIGHT/NUMBER_OF_SQUARES);
        }
    }
}
