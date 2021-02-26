package ir.co.isc.academy.g1.diskgame;

import java.lang.reflect.Array;
import java.util.*;

public class GameField {
    public static String[][] positions = new String[6][7];
    public static String winner;

    public static void setupField() {
        for (int i = 0; i < positions.length; i++) {
            Arrays.fill(positions[i], "-");
        }
    }

    public static void displayField() {
        for (String[] position : positions) {
            for (String s : position) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static boolean validateColumn(int colNum) {

        if(colNum >= 0 && colNum <= 6){
            return true;
        }else {
            throw new UnsupportedOperationException("Column Number should be between 1 and 7");
        }
    }

    public static boolean isPositionEmpty(int x, int y) {
        return positions[x][y] == "-";
    }

    public static Location getEmptyRow(int colNum) {
        Location location = new Location(0, 0);
        for (int i = 5; i >= 0; i--) {
            if (isPositionEmpty(i, colNum)) {
                location.setX(i);
                location.setY(colNum);
                break;
            }
        }
        return location;

    }

    public static boolean isGameDraw(String[][] array) {
        boolean flag = true;
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 6; row++) {
                if (array[row][col].equals("-")) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}

