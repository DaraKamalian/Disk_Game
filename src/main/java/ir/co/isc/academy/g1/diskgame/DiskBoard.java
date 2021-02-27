package ir.co.isc.academy.g1.diskgame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiskBoard {
    private final static Logger LOGGER = LoggerFactory.getLogger(DiskBoard.class);
    private int numOfRows;
    private int numOfCols;
    private String[][] gameBoard = new String[numOfRows][numOfCols];

    public DiskBoard(int numOfRows, int numOfCols) {
        this.numOfCols = numOfCols;
        this.numOfRows = numOfRows;
        this.gameBoard = new String[numOfRows][numOfCols];
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getNumOfCols() {
        return numOfCols;
    }

    public String[][] getGameBoard() {
        return gameBoard;
    }


    public void setupBoard() {
        LOGGER.info("Populating the game field with -");
        for (int i = 0; i < this.getNumOfRows(); i++) {
            for (int j = 0; j < this.getNumOfCols(); j++) {
                this.gameBoard[i][j] = "-";
            }
        }
    }

    public void displayBoard() {
        LOGGER.info("Displaying the game field on the console");
        for (int i = 0; i < this.getNumOfRows(); i++) {
            for (int j = 0; j < this.getNumOfCols(); j++) {
                System.out.print(this.gameBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public boolean validateColumn(int colNum) {
        LOGGER.info("Checking to see if the Column number is in range");
        if (colNum >= 0 && colNum <= 6) {
            return true;
        } else {
            throw new UnsupportedOperationException("Column Number should be between 1 and 7");
        }
    }

    public boolean isPositionEmpty(int x, int y) {
        LOGGER.info("Checking to see if the desired position is empty to make a move");
        return this.gameBoard[x][y].equals("-");
    }

    public Location getEmptyRow(int colNum) {
        LOGGER.info("Getting the row from the desired column which is empty and can be used");
        Location location = new Location(0, 0);
        for (int i = 5; i >= 0; i--) {
            if (this.isPositionEmpty(i, colNum)) {
                location.setX(i);
                location.setY(colNum);
                break;
            }
        }
        return location;

    }

    public boolean isGameDraw() {
        LOGGER.info("Checking If no more spots are left on the field the game is called a draw");
        boolean flag = true;
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 6; row++) {
                if (this.gameBoard[row][col].equals("-")) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public String getWinner() {
        LOGGER.info("Determining the winner of the game");
        String result = "";
        if (!ArrayOperations.getRowDuplicates(this).name.equals("-") &&
                ArrayOperations.getRowDuplicates(this).value == 4) {
            result = ArrayOperations.getRowDuplicates(this).name;
        }
        if (!ArrayOperations.getColDuplicates(this).name.equals("-") &&
                ArrayOperations.getColDuplicates(this).value == 4) {
            result = ArrayOperations.getColDuplicates(this).name;
        }
        return result;
    }

    public int getNumberOfDiscs(DiskBoard diskBoard) {
        int counter = 0;
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (!diskBoard.gameBoard[row][col].equals("-")) counter++;
            }
        }
        return counter;
    }
}

