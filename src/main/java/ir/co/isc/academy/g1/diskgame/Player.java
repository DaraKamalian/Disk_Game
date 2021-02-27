package ir.co.isc.academy.g1.diskgame;

public class Player {
    public int id;
    public Color color;

    public Player(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    public static void fillPosition(Color color, Location location) {
        GameField.positions[location.getX()][location.getY()] = color.toString();
    }


}
