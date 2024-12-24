public class Utilities {
    // Players
    public static String[] player1 = {"Player 1", "X"};
    public static String[] player2 = {"Player 2", "O"};

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
}
