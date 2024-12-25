public class TicTacToe {
    // board content
    public static String[][] board = new String[3][3];

    public static void main(String[] args) {
        menu();
        System.out.println(Utilities.SALUTATIONS);
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
        String[] player;

        Utilities.refreshBoard(board);
        do {
            player = Utilities.turnTracker(turnCounter);
            Utilities.assembleBoard(board);
            int[] selectedSpace = Validate.spaceSelection(board);
            Utilities.updateBoard(board, selectedSpace, player[1]);
            turnCounter++;
            if (turnCounter == 9) { //checks for stalemates
                break;
            }
        } while (Validate.checkWinner(board));
        Utilities.assembleBoard(board);

        if (!Validate.checkWinner(board)) {
            System.out.printf(Utilities.WINNER, player[0]);
            scoreTracker(player[0]);
        } else {
            System.out.println(Utilities.STALEMATE);
            scoreTracker(Utilities.players[2][0]);
        }
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

        String head = String.format(Utilities.playerScore, " " + Utilities.players[0][0], Utilities.players[2][0], " " + Utilities.players[1][0]);
        String body = String.format(Utilities.playerScore, Utilities.players[0][2], Utilities.players[2][2], Utilities.players[1][2]);
        String line = Utilities.lineMaker(head);


        System.out.printf(line + head + line + body + line);
    }
}
