public class TicTacToe {
    // board content
    public static String[][] board = { // I made the base board values uneven so that the verifier doesn't count blank spaces as a win
            {"", " ", ""},
            {" ", "", " "},
            {" ", "", " "}
    };

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int option = Validate.selectOption();

        switch (option) {
            case 1:
                game();
                break;
            case 2:
                Utilities.assembleBoard(Validate.backEndBoard);
                menu();
                break;
            case 3:
                System.out.println("Thank you for playing!");
                Validate.sc.close();
                break;
            default:
                System.out.println("Invalid option!");
                menu();
                break;
        }
    }

    public static void game() {
        int turnCounter = 0;
        String[] player = new String[2];

        while (Validate.isValid(board)) {
            player = Utilities.turnTracker(turnCounter);
            Utilities.assembleBoard(board);
            int[] selectedSpace = Validate.spaceSelection(board);
            Utilities.updateBoard(board, selectedSpace, player[1]);
            turnCounter++;
        }

        Utilities.assembleBoard(board);
        System.out.printf("\n%s is the winner!", player[0]);
    }

    public static void again() {

    }
}
