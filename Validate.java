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

        do {
            System.out.print("\nEnter the space you would like to select: ");
            input = sc.nextLine().trim(); // User inputs their selection
            if (isLetters(input)) {
                for (int i = 0; i < backendBoard.length; i++) { // Loops that verifies that the input exists
                    for (int j = 0; j < backendBoard[i].length; j++) {
                        slot[0] = i; slot[1] = j;
                        if (input.equalsIgnoreCase(backendBoard[i][j]) && !Utilities.isClaimed(board, slot)) { // checks if it exists and is claimed or not
                            return slot;
                        }
                    }
                }
                System.out.println("Selected space is either invalid or already claimed.");
            }
        } while (true);
    }

    public static boolean isLetters(String input) {
        try {
            Double.parseDouble(input);
            System.out.println("Invalid input");
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
