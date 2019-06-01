package sample;


import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;

    private static final int NUMBER_OF_SQUARES = 30;

    public Head head;
    List<Body> segments = new ArrayList<Body>();
    //List<Node> segments2 = new ArrayList<Node>();
    int speed;

    Snake(){
        head = new Head();
        head.direction = Head.Direction.UP;
    }

    public List<Node> fromListBodyToListNode(){
        List<Node> nodes = new ArrayList<Node>();
        for(int i=0;i<segments.size();i++){
            nodes.add(segments.get(i).body);
        }
        return nodes;
    }

    public void addBody(){
        Head.Direction direction;
        double x,y;
        Body body;
        if(segments.size()==0){
            direction = head.direction;
            x = head.head.getLayoutX();
            y = head.head.getLayoutY();

        }
        else {
            direction = segments.get(segments.size()-1).direction;
            x = segments.get(segments.size()-1).body.getLayoutX();
            y = segments.get(segments.size()-1).body.getLayoutY();
        }

        if(direction.equals(Segment.Direction.RIGHT)){
            body = new Body(x - GAME_WIDTH/NUMBER_OF_SQUARES,y);
            body.direction = direction;
            segments.add(body);
        }
        if(direction.equals(Segment.Direction.LEFT)){
            body = new Body(x + GAME_WIDTH/NUMBER_OF_SQUARES,y);
            body.direction = direction;
            segments.add(body);
        }
        if(direction.equals(Segment.Direction.UP)){
            body = new Body(x,y + GAME_HEIGHT/NUMBER_OF_SQUARES);
            body.direction = direction;
            segments.add(body);
        }
        if(direction.equals(Segment.Direction.DOWN)){
            body = new Body(x,y - GAME_HEIGHT/NUMBER_OF_SQUARES);
            body.direction = direction;
            segments.add(body);
        }
    }

    public void setDirection(Head.Direction direction){
        changeDirectionBody();
        head.direction = direction;
        head.moveHead();
    }

    public void changeDirectionBody(){
        if(segments.size()>0){
            for (int i=segments.size()-1;i>0;i--){
                segments.get(i).direction = segments.get(i-1).direction;
            }
            segments.get(0).direction = head.direction;
            moveBody();
        }
    }

    public void moveBody(){
        if(segments.size()>0) {
            for (int i = segments.size() - 1; i >= 0; i--) {
                segments.get(i).moveSegment();
            }
        }
    }
}
