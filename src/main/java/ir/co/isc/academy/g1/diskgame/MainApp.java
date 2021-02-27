package ir.co.isc.academy.g1.diskgame;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player(1, Color.R);
        Player player2 = new Player(2, Color.G);
        System.out.println("Player 1: Red");
        System.out.println("Player 2: Green");

        int playerTurn = 1;
        Color playerColor = Color.R;
        GameField.setupField();
        while (true) {
            System.out.print("Player " + playerColor + " Column:");

            int tempCol = scanner.nextInt();
            if (!ArrayOperations.isColumnFull(GameField.positions, tempCol)) {
                if (GameField.validateColumn(tempCol - 1)) {
                    if (playerTurn % 2 == 1) {
                        Player.fillPosition(Color.R, GameField.getEmptyRow(tempCol - 1));
                    } else {
                        Player.fillPosition(Color.G, GameField.getEmptyRow(tempCol - 1));
                    }
                }

                GameField.displayField();

                if (!GameField.getWinner().equals("") && GameField.getWinner().equals("R")) {
                    System.out.println("Winner is: Player1");
                    break;
                } else if (!GameField.getWinner().equals("") && GameField.getWinner().equals("G")) {
                    System.out.println("Winner is: Player2");
                    break;
                }


                if (GameField.isGameDraw(GameField.positions)) {
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
