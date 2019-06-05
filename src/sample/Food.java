package sample;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

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
    private String APPLE_URL = "resources/apple-icon.png";
    private String PIZZA_URL = "resources/pizza-icon.png";
    private String FROG_URL = "resources/frog-icon.png";

    private Node node;

    public Food(String jedzonko){
        switch(jedzonko){
            case "cherry":
                node = new ImageView(FOOD_URL);
                break;
            case "apple":
                node = new ImageView(APPLE_URL);
                break;
            case "pizza":
                node = new ImageView(PIZZA_URL);
                break;
            case "frog":
                node = new ImageView(FROG_URL);
                break;
        }

        ((ImageView) node).setFitWidth(GAME_WIDTH/NUMBER_OF_SQUARES);
        ((ImageView) node).setFitHeight(GAME_HEIGHT/NUMBER_OF_SQUARES);
        node.setId("food");
    }

}
