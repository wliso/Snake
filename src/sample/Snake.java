package sample;


import java.util.ArrayList;
import java.util.List;

public class Snake {
    public Head head;
    List<Body> segments = new ArrayList<Body>();
    int speed;
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
    Snake(){
        head = new Head();
    }
}
