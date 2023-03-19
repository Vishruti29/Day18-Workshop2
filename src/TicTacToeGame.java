public class TicTacToeGame {
    private char[] board = new char[10];

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

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.displayBoard();
    }

}
