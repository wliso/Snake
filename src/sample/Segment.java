package sample;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;

public class Segment {
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    Direction direction;
    Point2D position;
    Image icon;

}
