import java.util.Arrays;

public class TicTacToe {
    // board content
    public static String[][] board = { // I made the base board values uneven so that the verifier doesn't count blank spaces as a win
            {"", " ", ""},
            {" ", "", " "},
            {" ", "", " "}
    };

    public static void main(String[] args) {
        program();
    }

    public static void program() {
        int turnCounter = 0;
        String[] player = new String[2];

        while (Validate.isValid(board)) {
            int[] selectedSpace = new int[2];
            player = Utilities.turnTracker(turnCounter);

            Utilities.assembleBoard(board);
            selectedSpace = Validate.spaceSelection(board);

            Utilities.updateBoard(board, selectedSpace, player[1]);

            turnCounter++;
        }

        Utilities.assembleBoard(board);
        System.out.printf("\n%s is the winner!", player[0]);
    }




}
