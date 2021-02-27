package ir.co.isc.academy.g1.diskgame;

import java.util.ArrayList;

public class Player {
    public int id;
    public Color color;

    static ArrayList<String> testList = new ArrayList<String>();

    public Player(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    public void fillPosition(DiskBoard diskBoard, Location location) {
        diskBoard.getGameBoard()[location.getX()][location.getY()] = this.color.toString();
        testList.add("Filled");
    }


}
