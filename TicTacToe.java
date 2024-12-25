import java.util.Arrays;

public class TicTacToe {
    // board content
    public static String[][] board = new String[3][3];

    public static void main(String[] args) {
        menu();
        System.out.println("Thank you for playing!");
        Validate.sc.close();
    }

    public static void menu() {
        boolean rematch = true;
        boolean finished = false;

        do {
            int option = Validate.selectOption();
            switch (option) {
                case 1:
                    while (rematch) {
                        game();
                        rematch = again();
                    }
                    finished = true;
                    break;
                case 2:
                    Utilities.assembleBoard(Validate.backEndBoard);
                    break;
                case 3:
                    finished = true;
                    break;
                default:
                    System.out.println(Utilities.INVALID_OPTION);
                    break;
            }
        } while (!finished);
    }

    public static void game() {
        int turnCounter = 0;
        String[] player = new String[2];
        Utilities.refreshBoard(board);

        while (Validate.isValid(board)) {
            player = Utilities.turnTracker(turnCounter);
            Utilities.assembleBoard(board);
            int[] selectedSpace = Validate.spaceSelection(board);
            Utilities.updateBoard(board, selectedSpace, player[1]);
            turnCounter++;
        }

        Utilities.assembleBoard(board);
        System.out.printf("\n%s is the winner!", player[0]);
        scoreTracker(player[0]);
    }

    public static boolean again() {
        while (true) {
            System.out.print(Utilities.REMATCH);
            String input = Validate.sc.nextLine();
            if (Validate.isLetters(input)) {
                if (input.equalsIgnoreCase(Utilities.YES)) {
                    return true;
                } else if (input.equalsIgnoreCase(Utilities.NO)) {
                    return false;
                } else {
                    System.out.println(Utilities.INVALID_OPTION);
                }
            }
        }
    }

    public static void scoreTracker(String player) {
        for (int i = 0; i < Utilities.players.length; i++) {
            if (player.equals(Utilities.players[i][0])) {
                int counter = Integer.parseInt(Utilities.players[i][2]);
                Utilities.players[i][2] = String.valueOf(++counter);
            }
        }
        System.out.printf(Utilities.playerScore, Utilities.players[0][2], Utilities.players[1][2]);
    }
}
