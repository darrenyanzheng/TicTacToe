import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        while (true) {
            System.out.println("Please enter a number from 1-9.");
            Scanner scanner = new Scanner(System.in);
            int position = scanner.nextInt();
            boolean result = validMove(gameBoard, position);
            while (!result) {
                System.out.println("Invalid move. Try again.");
                position = scanner.nextInt();
                result = validMove(gameBoard, position);
            }

            place(gameBoard, position, "user");

            boolean winner = checkWinner(gameBoard, "user");
            if (winner) {
                break;
            }

            Random random = new Random();
            int cpuPosition = random.nextInt(9) + 1;
            boolean cpuResult = validMove(gameBoard, cpuPosition);
            while (!cpuResult) {
                cpuPosition = random.nextInt(9) + 1;
                cpuResult = validMove(gameBoard, cpuPosition);

            }
            place(gameBoard, cpuPosition, "computer");

            printGameBoard(gameBoard);
            boolean cpuWinner = checkWinner(gameBoard, "computer");
            if (cpuWinner) {
                break;
            }
        }
        System.out.println("Thanks for playing!");

    }
    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println("");
        }
    }
    public static void place(char[][] gameBoard, int position, String player) {

        char symbol = 'k';
        if (player.equals("user")) {
            symbol = 'X';
        } else if (player.equals("computer")) {
            symbol = 'O';
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                System.out.println("Please input a number from 1-9.");

        }
    }

    public static boolean checkWinner(char[][] gameBoard, String player) {
        char symbol = 'k';
        if (player.equals("user")) {
            symbol = 'X';
        } else if (player.equals("computer")) {
            symbol = 'O';
        }

        if ((gameBoard[0][0] == symbol && gameBoard[0][2] == symbol && gameBoard[0][4] == symbol) ||
                (gameBoard[2][0] == symbol && gameBoard[2][2] == symbol && gameBoard[2][4] == symbol) ||
                (gameBoard[4][0] == symbol && gameBoard[4][2] == symbol && gameBoard[4][4] == symbol) ||
                (gameBoard[0][0] == symbol && gameBoard[2][0] == symbol && gameBoard[4][0] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[2][2] == symbol && gameBoard[4][2] == symbol) ||
                (gameBoard[0][4] == symbol && gameBoard[2][4] == symbol && gameBoard[4][4] == symbol) ||
                (gameBoard[0][0] == symbol && gameBoard[2][2] == symbol && gameBoard[4][4] == symbol) ||
                (gameBoard[0][4] == symbol && gameBoard[2][2] == symbol && gameBoard[4][0] == symbol)) {
            printGameBoard(gameBoard);
            System.out.println(player + " wins");
            return true;
        }
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        printGameBoard(gameBoard);
        System.out.println("The game ended in a tie!");
        return true;
    }

    public static boolean validMove (char [][]gameBoard, int position) {
        switch (position) {
            case 1:
                if (gameBoard[0][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (gameBoard[0][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (gameBoard[0][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (gameBoard[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (gameBoard[2][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (gameBoard[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (gameBoard[4][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (gameBoard[4][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (gameBoard[4][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;

        }
    }
}


