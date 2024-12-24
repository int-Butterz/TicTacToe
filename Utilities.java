public class Utilities {
    // Players
    public static String[] player1 = {"Player 1", "X"};
    public static String[] player2 = {"Player 2", "O"};

    //board output
    public static String rowSeperator = "-";
    public static String colSeperator = "\n|%1s|%1s|%1s|\n";

    public static void assembleBoard(String[][] board) {
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
}
