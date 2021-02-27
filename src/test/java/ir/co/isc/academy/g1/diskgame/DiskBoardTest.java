package ir.co.isc.academy.g1.diskgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskBoardTest {
    DiskBoard diskBoard = new DiskBoard(6, 7);

    @Test
    void validateColumn() {

        int colNum = 2;
        assertEquals(diskBoard.validateColumn(colNum), true);

    }
    @Test
    void isGameDraw() {
        diskBoard.setupBoard();
        assertEquals(diskBoard.isGameDraw(), false);
    }


    @Test
    void getNumberOfDiscs() {
        diskBoard.setupBoard();
        assertEquals(diskBoard.getNumberOfDiscs(diskBoard), 0);
    }

}