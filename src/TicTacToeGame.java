import java.util.Scanner;

public class TicTacToeGame {
    private char[] board = new char[10];
    private char playerLetter;
    private char computerLetter;

    public TicTacToeGame() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
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

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.chooseLetter();
        game.showBoard();
    }
}