import java.util.Arrays;

public class TicTacToe {
    //board content
    public static String[][] board = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };

    //board output
    public static String rowSeperator = "-";
    public static String colSeperator = "\n|%1s|%1s|%1s|\n";

    public static void main(String[] args) {
        assembleBoard();
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
