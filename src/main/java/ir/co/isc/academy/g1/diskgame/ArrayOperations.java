package ir.co.isc.academy.g1.diskgame;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TransferQueue;

public class ArrayOperations {

    public static String getRowDuplicates(String[][] array) {
        int rowDupCounter = 0;
        String rowdupString = "";
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if (array[row][col].equals(array[row][col + 1]) && !(array[row][col].equals("-"))) {
                    rowDupCounter++;
                    if (rowDupCounter == 3) {
                        rowdupString = array[row][col];
                        break;
                    }
                }
            }
        }
        return rowdupString;
    }

    public static String getColDuplicates(String[][] array) {
        int colDupCounter = 0;
        String colDupString = "";
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 5; row++) {
                if (array[row][col].equals(array[row + 1][col]) && !(array[row][col].equals("-"))) {
                    colDupCounter++;
                    if (colDupCounter == 3) {
                        colDupString = array[row][col];
                        break;

                    }
                }
            }
        }
        return colDupString;
    }

    public static String getDiagonalDuplicates(String[][] array) {
        int diagDupCounter = 0;
        String diagColString = "";
        for (int row = 0; row < 5; row++) {
            for (int col = 6; col > 1; col--) {
                if (array[row][col].equals(array[row + 1][col - 1]) && !array[row][col].equals("-")) {
                    diagDupCounter++;
                    if (diagDupCounter == 3) {
                        diagColString = array[row][col];
                        break;
                    }
                }
            }

        }
        return diagColString;
    }

    public static boolean isColumnFull(String[][] array, int colNum) {
        boolean result = false;
        for (int row = 0; row < 6; row++) {
            if(array[row][colNum-1].equals("-")) break;
            else result = true;
        }
        return result;
    }
}
