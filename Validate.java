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

    public static String[] slotSelection() {
        String input;
        String[] slot = new String[2];
        boolean isValid = false;

        do {
            try {
                input = sc.nextLine();

                for (int i = 0; i < backendBoard.length; i++) {
                    for (int j = 0; j < backendBoard[i].length; j++) {
                        if (input.equalsIgnoreCase(backendBoard[i][j])) {
                            slot[0] = Integer.toString(i); slot[1] = Integer.toString(j);
                            isValid = true;
                            break;
                        }
                    }
                }
                System.out.println("Selected slot is invalid");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }

        } while (!isValid);
        return slot;
    }
}
