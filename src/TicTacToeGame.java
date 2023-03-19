import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private char[] board = new char[10];
    private char playerLetter;
    private char computerLetter;
    private boolean playerTurn;

    public TicTacToeGame() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        playerTurn = false;
    }

    public void displayBoard() {
        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9] + " ");
    }

    public void showBoard() {
        System.out.println("Current board:");
        displayBoard();
        System.out.println();
    }

    public void chooseLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your letter: X or O");
        playerLetter = scanner.nextLine().toUpperCase().charAt(0);
        while (playerLetter != 'X' && playerLetter != 'O') {
            System.out.println("Invalid input. Choose your letter: X or O");
            playerLetter = scanner.nextLine().toUpperCase().charAt(0);
        }
        if (playerLetter == 'X') {
            computerLetter = 'O';
        } else {
            computerLetter = 'X';
        }
        System.out.println("You chose " + playerLetter + ". Computer will be " + computerLetter + ".");
    }

    public boolean makeMove(int index, char letter) {
        if (index < 1 || index > 9) {
            System.out.println("Invalid input. Choose a number from 1 to 9.");
            return false;
        }
        if (board[index] != ' ') {
            System.out.println("That cell is already occupied. Choose a different cell.");
            return false;
        }
        board[index] = letter;
        return true;
    }

    public void tossCoin() {
        Random random = new Random();
        int result = random.nextInt(2);
        if (result == 0) {
            System.out.println("Heads! You play first.");
            playerTurn = true;
        } else {
            System.out.println("Tails! Computer plays first.");
        }
    }
    public void playComputerTurn() {
        System.out.println("Computer's turn");
        int computerMove = -1;

        // Check if computer can win in the next move
        for (int i = 1; i <= 9; i++) {
            if (board[i] == ' ') {
                board[i] = computerLetter;
                if (checkForWin(computerLetter)) {
                    computerMove = i;
                    break;
                }
                board[i] = ' ';
            }
        }

        // If computer cannot win, make a random move
        if (computerMove == -1) {
            computerMove = getRandomMove();
        }

        board[computerMove] = computerLetter;
        currentTurn = playerLetter;
        showBoard();
    }


    public boolean checkWinner(char letter) {
        // Check rows
        if (board[1] == letter && board[2] == letter && board[3] == letter) return true;
        if (board[4] == letter && board[5] == letter && board[6] == letter) return true;
        if (board[7] == letter && board[8] == letter && board[9] == letter) return true;
        // Check columns
        if (board[1] == letter && board[4] == letter && board[7] == letter) return true;
        if (board[2] == letter && board[5] == letter && board[8] == letter) return true;
        if (board[3] == letter && board[6] == letter && board[9] == letter) return true;
        // Check diagonals
    }
}

