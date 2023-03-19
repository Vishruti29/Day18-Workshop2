import java.util.*;

public class TicTacToeGame {
    static char[] board = new char[10];
    static char playerLetter;
    static char computerLetter;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void createBoard() {
        Arrays.fill(board, ' ');
    }

    public static void chooseLetter() {
        while (true) {
            System.out.print("Choose a letter 'X' or 'O': ");
            char letter = Character.toUpperCase(scanner.next().charAt(0));
            if (letter == 'X' || letter == 'O') {
                playerLetter = letter;
                computerLetter = (playerLetter == 'X') ? 'O' : 'X';
                break;
            } else {
                System.out.println("Invalid choice. Please choose 'X' or 'O'.");
            }
        }
    }

    public static void showBoard() {
        System.out.println("\nBoard:");
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    public static void makeMove(char letter, int position) {
        board[position] = letter;
    }

    public static boolean isSpaceFree(int position) {
        return board[position] == ' ';
    }

    public static int getUserMove() {
        while (true) {
            System.out.print("Enter a position (1-9) to make a move: ");
            int move = scanner.nextInt();
            if (move >= 1 && move <= 9 && isSpaceFree(move)) {
                return move;
            } else {
                System.out.println("Invalid move. Please choose an empty cell between 1-9.");
            }
        }
    }

    public static int getComputerMove() {
        for (int i = 1; i < board.length; i++) {
            if (isSpaceFree(i)) {
                makeMove(computerLetter, i);
                if (checkWinner(board, computerLetter)) {
                    board[i] = ' ';
                    return i;
                }
                board[i] = ' ';
            }
        }

        for (int i = 1; i < board.length; i++) {
            if (isSpaceFree(i)) {
                makeMove(playerLetter, i);
                if (checkWinner(board, playerLetter)) {
                    board[i] = ' ';
                    return i;
                }
                board[i] = ' ';
            }
        }

        int[] corners = {1, 3, 7, 9};
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        for (int i : corners) {
            if (isSpaceFree(i)) {
                possibleMoves.add(i);
            }
        }
        if (!possibleMoves.isEmpty()) {
            return possibleMoves.get(random.nextInt(possibleMoves.size()));
        }

        if (isSpaceFree(5)) {
            return 5;
        }

        int[] sides = {2, 4, 6, 8};
        possibleMoves.clear();
        for (int i : sides) {
            if (isSpaceFree(i)) {
                possibleMoves.add(i);
            }
        }
        if (!possibleMoves.isEmpty()) {
            return possibleMoves.get(random.nextInt(possibleMoves.size()));
        }

    }
}