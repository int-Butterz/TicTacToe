public class Utilities {
    // Players
    public static String[] player1 = {"Player 1", " X "};
    public static String[] player2 = {"Player 2", " O "};

    //board output
    public static String rowSeperator = "-";
    public static String colSeperator = "\n|%3s|%3s|%3s|";

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
            System.out.println("\nPlayer 1's turn");
            return player1;
        } else {
            System.out.println("\nPlayer 2's turn");
            return player2;
        }
    }

    public static void updateBoard(String[][] board, int[] slot, String player) {
        board[slot[0]][slot[1]] = player;
    }

    public static boolean isClaimed(String[][] board, int[] slot) {
        if (board[slot[0]][slot[1]].equals(Utilities.player1[1]) || board[slot[0]][slot[1]].equals(Utilities.player2[1])) {
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
