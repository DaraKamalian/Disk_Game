package ir.co.isc.academy.g1.diskgame;

public class ArrayOperations {

    public static Tuple getRowDuplicates(DiskBoard diskBoard) {
        System.out.println("row called");
        int rowDupCounter = 1;
        String rowDupString = "";
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if (diskBoard.getGameBoard()[row][col].equals(diskBoard.getGameBoard()[row][col + 1]) &&
                        !(diskBoard.getGameBoard()[row][col].equals("-"))) {
                    rowDupCounter++;
                    if (rowDupCounter == 4) {
                        rowDupString = diskBoard.getGameBoard()[row][col];
                        break;
                    }
                }
            }
        }
        return new Tuple(rowDupString, rowDupCounter);
    }

    public static Tuple getColDuplicates(DiskBoard diskBoard) {
        System.out.println("col called");
        int colDupCounter = 1;
        String colDupString = "";
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 5; row++) {
                if (diskBoard.getGameBoard()[row][col].equals(diskBoard.getGameBoard()[row + 1][col]) &&
                        !(diskBoard.getGameBoard()[row][col].equals("-"))) {
                    colDupCounter++;
                    if (colDupCounter == 4) {
                        colDupString = diskBoard.getGameBoard()[row][col];
                        break;

                    }
                }
            }
        }
        return new Tuple(colDupString, colDupCounter);
    }

    public static boolean isColumnFull(String[][] array, int colNum) {
        boolean result = false;
        for (int row = 0; row < 6; row++) {
            if (array[row][colNum - 1].equals("-")) break;
            else result = true;
        }
        return result;
    }
}
