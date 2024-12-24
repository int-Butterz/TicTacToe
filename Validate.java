import java.util.Objects;

public class Validate {

    public static boolean isValid(String[][] board) {
        // Checks for rows
        for (int row = 0; row < board.length; row++) {
            if (Objects.equals(board[row][0], board[row][1]) && Objects.equals(board[row][1], board[row][2])) { // checks the rows
                return false; // Returns false to stop the while loop
            }
        }
        // Checks for columns
        for (int column = 0; column < board.length; column++) {
            if (Objects.equals(board[0][column], board[1][column]) && Objects.equals(board[1][column], board[2][column])) { // checks the columns
                return false; // Returns false to stop the while loop
            }
        }
        // Checks for diagonals
        if (Objects.equals(board[0][0], board[1][1]) && Objects.equals(board[1][1], board[2][2])) { // checks for TL-BR diagonal
            return false; // Returns false to stop the while loop
        } else if (Objects.equals(board[0][2], board[1][1]) && Objects.equals(board[1][1], board[2][0])) { // checks for TR-BL diagonal
            return false; // Returns false to stop the while loop
        }
        return true; // Returns true to continue the loop
    }
}
