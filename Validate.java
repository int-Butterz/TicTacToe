import java.util.InputMismatchException;
import java.util.Scanner;

public class Validate {
    static Scanner sc = new Scanner(System.in);

    // Options
    public static String[][] backendBoard = {
            {"TL", "T", "TR"},
            {"L", "M", "R"},
            {"BL", "B", "BR"}
    };

    public static boolean isValid(String[][] board) {
        // Checks for rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])) { // checks the rows
                return false; // Returns false to stop the while loop
            }
        }
        // Checks for columns
        for (int column = 0; column < board.length; column++) {
            if (board[0][column].equals(board[1][column]) && board[1][column].equals(board[2][column])) { // checks the columns
                return false; // Returns false to stop the while loop
            }
        }
        // Checks for diagonals
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) { // checks for TL-BR diagonal
            return false; // Returns false to stop the while loop
        } else if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) { // checks for TR-BL diagonal
            return false; // Returns false to stop the while loop
        }
        return true; // Returns true to continue the loop
    }

    public static int[] spaceSelection(String[][] board) {
        String input;
        int[] slot = new int[2];
        boolean isValid = false;

        do {
            System.out.print("\nEnter the space you would like to select: ");
            try {
                input = sc.nextLine().trim(); // User inputs their selection
                // Loops that verifies that the input exists
                for (int i = 0; i < backendBoard.length; i++) {
                    for (int j = 0; j < backendBoard[i].length; j++) {
                        slot[0] = i; slot[1] = j;
                        if (input.equalsIgnoreCase(backendBoard[i][j]) && !isClaimed(board, slot)) { // checks if it exists and is claimed or not
                            isValid = true;
                            return slot;
                        }
                    }
                }

                if (!isValid && !isClaimed(board, slot)) { // Message if it doesnt exist
                    System.out.println("Selected space is invalid");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }

        } while (!isValid);
        return slot;
    }

    public static boolean isClaimed(String[][] board, int[] slot) {
        if (board[slot[0]][slot[1]].equals(Utilities.player1) || board[slot[0]][slot[1]].equals(Utilities.player2)) {
            System.out.println("This space is already taken!");
            return true;
        }
        return false;
    }
}
