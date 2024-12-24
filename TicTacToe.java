import java.util.Arrays;

public class TicTacToe {
    // board content
    public static String[][] board = { // I made the base board values uneven so that the verifier doesn't count blank spaces as a win
            {"", " ", ""},
            {" ", "", " "},
            {" ", "", " "}
    };

    //board output
    public static String rowSeperator = "-";
    public static String colSeperator = "\n|%1s|%1s|%1s|\n";

    // Players
    public static String player1 = "X";
    public static String player2 = "O";

    public static void main(String[] args) {
        program();
    }

    public static void program() {
        while (Validate.isValid(board)) {
            assembleBoard();
        }
        System.out.println("winner");
    }

    public static void assembleBoard() {
        StringBuilder line = new StringBuilder();
        for (int j = 0; j < colSeperator.length()/2; j++) {
            line.append(rowSeperator);
        }

        System.out.print(line);
        for (int i = 0; i < 3; i++) {
            System.out.printf(colSeperator, board[i][0], board[i][1], board[i][2]);
            System.out.print(line);
        }
    }
}
