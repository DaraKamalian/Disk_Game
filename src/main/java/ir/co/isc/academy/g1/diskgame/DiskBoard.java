package ir.co.isc.academy.g1.diskgame;

public class DiskBoard {
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
        for (int i = 0; i < this.getNumOfRows(); i++) {
            for (int j = 0; j < this.getNumOfCols(); j++) {
                this.gameBoard[i][j] = "-";
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < this.getNumOfRows(); i++) {
            for (int j = 0; j < this.getNumOfCols(); j++) {
                System.out.print(this.gameBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public boolean validateColumn(int colNum) {
        if (colNum >= 0 && colNum <= 6) {
            return true;
        } else {
            throw new UnsupportedOperationException("Column Number should be between 1 and 7");
        }
    }

    public boolean isPositionEmpty(int x, int y) {
        return this.gameBoard[x][y].equals("-");
    }

    public Location getEmptyRow(int colNum) {
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

