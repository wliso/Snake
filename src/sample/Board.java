package sample;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class Board {
    Snake snake;
    Food food;
    List<Wall> wallList = new ArrayList<Wall>();
    List<Segment> nodes = new ArrayList<Segment>();
    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;

    private static final int NUMBER_OF_SQUARES = 30;
    void drawBoard(){}
    boolean collision(){
        return false;
    }

    void AddWall()
    {
        Wall wall;
        for(int j = 0; j< GAME_HEIGHT ; j = j+GAME_HEIGHT-(GAME_HEIGHT/NUMBER_OF_SQUARES))
        {
            for(int i = 0; i < GAME_WIDTH; i = i +(GAME_WIDTH/NUMBER_OF_SQUARES))
            {
                wall = new Wall(i, j);
                wallList.add(wall);
                nodes.add(wall);
            }
        }
        for(int j = 0; j< GAME_HEIGHT ; j = j+GAME_HEIGHT-(GAME_HEIGHT/NUMBER_OF_SQUARES))
        {
            for(int i = 0; i < GAME_WIDTH; i = i +(GAME_WIDTH/NUMBER_OF_SQUARES))
            {
                wall = new Wall(j, i);
                wallList.add(wall);
                nodes.add(wall);
            }
        }

    }
    public List<Node> fromListWallToListNode(){
        List<Node> nodess = new ArrayList<Node>();
        for(int i=0;i<wallList.size();i++){
            nodess.add(wallList.get(i).getNode());
        }
        return nodess;
    }

}
