package ir.co.isc.academy.g1.diskgame;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp {
    private final static Logger LOGGER = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        LOGGER.info("Game Started");

        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player(1, Color.R);
        Player player2 = new Player(2, Color.G);

        DiskBoard diskBoard = new DiskBoard(6, 7);

        System.out.println("Player 1: Red");
        System.out.println("Player 2: Green");

        int playerTurn = 1;
        Color playerColor = Color.R;
        diskBoard.setupBoard();
        while (true) {
            System.out.print("Player " + playerTurn + " Column:");

            int tempCol = scanner.nextInt();
            if (!ArrayOperations.isColumnFull(diskBoard.getGameBoard(), tempCol)) {
                if (diskBoard.validateColumn(tempCol - 1)) {
                    if (playerTurn % 2 == 1) {
                        player1.fillPosition(diskBoard, diskBoard.getEmptyRow(tempCol - 1));
                    } else {
                        player2.fillPosition(diskBoard, diskBoard.getEmptyRow(tempCol - 1));
                    }
                }

                diskBoard.displayBoard();
                String result = diskBoard.getWinner();

                if (!result.equals("") && result.equals("R")) {
                    System.out.println("Winner is: Player1");
                    break;
                } else if (!result.equals("") && result.equals("G")) {
                    System.out.println("Winner is: Player2");
                    break;
                }


                if (diskBoard.isGameDraw()) {
                    System.out.println("Game Has No Winner");
                    break;
                }
                playerTurn++;
                if (playerTurn % 2 == 0) {
                    playerColor = Color.G;
                    playerTurn = 2;
                } else {
                    playerTurn = 1;
                    playerColor = Color.R;
                }

            } else System.out.println("Column is Full! ");

        }

    }
}
