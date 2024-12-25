public class Utilities {
    // Players
    public static String[][] players = {
            {"Player 1", " X ", "0"},
            {"Player 2", " O ", "0"},
            {"Stalemates", "   ", "0"},
    };
    public static final String PLAYER_TURN = "\n%s's turn";
    public static String playerScore = "\n|%-10s|%-10s|%-10s|";
    //Board Output
    public static String rowSeperator = "-";
    public static String colSeperator = "\n|%3s|%3s|%3s|";
    //Error Messages
    public static final String INVALID_OPTION = "Invalid option!";
    public static final String INVALID_INPUT = "Invalid input!";
    public static final String INVALID_SPACE = "Selected space is either invalid or already claimed.";
    //Yes or No
    public static final String REMATCH = "\nWould you like to play again? (Y/N): ";
    public static final String YES = "Y";
    public static final String NO = "N";
    //Menu
    public static final String TITLE = "\nWelcome to TicTacToe! What would you like to do?";
    public static final String OPTIONS = "\n1. Play game\n2. Reference board\n3. Exit\n";
    public static final String SALUTATIONS = "\nThank you for playing!";
    // Victory
    public static final String WINNER = "\n%s is the winner!\n";
    public static final String STALEMATE = "\nThe game ended on a stalemate.";

    public static void assembleBoard(String[][] board) {
        for (int i = 0; i < 3; i++) {
            String row = String.format(colSeperator, board[i][0], board[i][1], board[i][2]);
            String line = lineMaker(row); // creates the seperators

            if (i == 2) { // if statement makes sure there is a line at the end of the board
                System.out.print(line + row + line);
            } else {
                System.out.print(line + row);
            }
        }
    }

    public static String[] turnTracker(int turnCounter) {
        if (turnCounter % 2 == 0) {
            System.out.printf(PLAYER_TURN, players[0][0]);
            return players[0];
        } else {
            System.out.printf(PLAYER_TURN, players[1][0]);
            return players[1];
        }
    }

    public static void updateBoard(String[][] board, int[] slot, String player) {
        board[slot[0]][slot[1]] = player;
    }

    public static void refreshBoard(String[][] board) {
        // I made the base board values uneven so that the verifier doesn't count blank spaces as a win
        board[0][0] = "";  board[0][1] = " "; board[0][2] = "";
        board[1][0] = " "; board[1][1] = "";  board[1][2] = " ";
        board[2][0] = " "; board[2][1] = "";  board[2][2] = " ";

    }

    public static boolean isClaimed(String[][] board, int[] slot) {
        if (board[slot[0]][slot[1]].equals(Utilities.players[0][1]) || board[slot[0]][slot[1]].equals(Utilities.players[1][1])) {
            return true;
        }
        return false;
    }

    public static String lineMaker(String string) {
        String line = "";
        for (int j = 0; j < string.length()-1; j++) { // creates the seperators
            line += rowSeperator;
        }
        return "\n" + line;
    }
}
