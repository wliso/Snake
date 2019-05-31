package sample;

import java.util.ArrayList;
import java.util.List;

public class Board {
    Snake snake;
    Food food;
    List<Wall> wallList = new ArrayList<Wall>();
    void drawBoard(){}
    boolean collision(){
        return false;
    }
}
