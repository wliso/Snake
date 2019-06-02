package sample;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Segment {
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    Direction direction;
    public abstract String getid();
    private Node node = new ImageView();
    public abstract Node getNode();
    Image icon;

}
