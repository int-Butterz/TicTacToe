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

    public static void main(String[] args) {
        program();
    }

    public static void program() {
        int turnCounter = 0;
        String[] player = new String[2];

        while (Validate.isValid(board)) {
            int[] selectedSpace = new int[2];
            player = Utilities.turnTracker(turnCounter);

            assembleBoard();
            selectedSpace = Validate.spaceSelection(board);

            Utilities.updateBoard(board, selectedSpace, player[1]);

            turnCounter++;
        }

        assembleBoard();
        System.out.printf("\n%s is the winner!", player[0]);
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
