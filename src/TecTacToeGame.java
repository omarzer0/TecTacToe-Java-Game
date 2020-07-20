import java.util.Arrays;
import java.util.Scanner;

public class TecTacToeGame {
    private static int turns = 0;
    private static final int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    private static final int human = 0;
    private static final String humanChar = "A";
    private static final int[] humanMoves = new int[]{9, 9, 9, 9, 9};
    private static int humanMovesIndexTracker = 0;

    private static final int computer = 1;
    private static final String computerChar = "B";
    private static final int[] computerMoves = new int[]{9, 9, 9, 9, 9};
    private static int computerMovesIndexTracker = 0;

    private static final Scanner sc = new Scanner(System.in);
    private static final int[][] winningStates = new int[][]{
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 4, 8},

            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {2, 4, 6}

    };

    private static final String[] arr = new String[]{
            "0", "1", "2",
            "3", "4", "5",
            "6", "7", "8"};

    public static void main(String[] args) {
        printArray();
        humanTurn();
    }

    private static void humanTurn() {
        System.out.print("Player1 choose a free spot: ");
        int humanLastMove = sc.nextInt();

        boolean isFree = checkIfSpotIsFree(humanLastMove);
        if (isFree) {
            arr[humanLastMove] = humanChar;
            humanMoves[humanMovesIndexTracker] = humanLastMove;
            humanMovesIndexTracker++;

            System.out.println("Player1 move is:");
            printArray();
            System.out.println();
        } else {
            System.out.println("this spot is not free");
            humanTurn();
        }

        boolean theGameEnds = checkIfTheGameEnds(human);
        if (theGameEnds && turns <=9) {
            // congrats
            done();
            System.out.println("Player 1 Wins");
        }else if (!theGameEnds && turns == 9){
            done();
            System.out.println("Oooooooooops! It's a Draw");
            System.exit(1);
        } else {
            computerTurn();
        }
    }

    private static void computerTurn() {
        // test case
        System.out.print("Player2 choose a free spot: ");
        int computerLastMove = sc.nextInt();

        boolean isFree = checkIfSpotIsFree(computerLastMove);
        if (isFree) {
            arr[computerLastMove] = computerChar;
            computerMoves[computerMovesIndexTracker] = computerLastMove;
            computerMovesIndexTracker++;

            System.out.println("Player2 move is:");
            printArray();
            System.out.println();
        } else {
            System.out.println("this spot is not free");
            computerTurn();
        }

        boolean theGameEnds = checkIfTheGameEnds(computer);
        if (theGameEnds && turns <=9) {
            // congrats
            done();
            System.out.println("Player 2 Wins");
        }else if (!theGameEnds && turns == 9){
            done();
            System.out.println("Oooooooooops! It's a Draw");
            System.exit(1);
        } else {
            humanTurn();
        }
    }

    private static boolean checkIfSpotIsFree(int move) {
        boolean isFree;
        if (arr[move].equals(humanChar) || arr[move].equals(computerChar)) {
            // not free
            isFree = false;
        } else {
            // free
            isFree = true;
        }
        return isFree;
    }

    private static boolean checkIfTheGameEnds(int currentPlayer) {
        turns++;
        int counter = 0;
        boolean gameEnds = false;
        boolean isThree = false;
        if (currentPlayer == human) {
            for (int[] winningState : winningStates) { //{0,1,2} winningStates[0]
                for (int j = 0; j < 3; j++) { // 0     winningStates[0][0]
                    for (int humanMove : humanMoves) {
                        if (winningState[j] == humanMove) { // 0==0? & 0 == 1 & 0 ==2
                            counter++;
                        }
                        if (counter == 3){
                            isThree = true;
                        }
                    }
                }
                counter = 0;
            }
        } else if (currentPlayer == computer) {
            for (int[] winningState : winningStates) { //{0,1,2} winningStates[0]
                for (int j = 0; j < 3; j++) { // 0     winningStates[0][0]
                    for (int computerMove : computerMoves) { // 0==0? & 0 == 1 & 0 ==2
                        if (winningState[j] == computerMove) {
                            counter++;
                        }
                        if (counter == 3){
                            isThree = true;
                        }
                    }
                }
                counter = 0;
            }
        }

        if (isThree) {
            gameEnds = true;
        }
        return gameEnds;
    }

    private static void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if (!(i == 2 || i == 5 || i == 8)) {
                System.out.print("\t" + "|" + "\t");
            }

            if (i == 2 || i == 5) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void done() {

        System.out.println(
                "******************************************************");
        System.out.println(
                "******************************************************");
        System.out.println(
                "******************************************************");
        System.out.println(
                "******" + "            **        **************      " + "******");
        System.out.println(
                "******" + "           ** **      **************      " + "******");
        System.out.println(
                "******" + "          **   **                ***      " + "******");
        System.out.println(
                "******" + "         **     **             ***        " + "******");
        System.out.println(
                "******" + "        ** ***** **          ***          " + "******");
        System.out.println(
                "******" + "        ** ***** **        ***            " + "******");
        System.out.println(
                "******" + "        **       **     ***               " + "******");
        System.out.println(
                "******" + "        **       **   **************      " + "******");
        System.out.println(
                "******" + "        **       **   **************      " + "******");
        System.out.println(
                "******************************************************");
        System.out.println(
                "******************************************************");
        System.out.println(
                "******************************************************");

    }
}