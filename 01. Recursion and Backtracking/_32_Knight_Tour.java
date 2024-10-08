import java.util.Scanner;

public class _32_Knight_Tour {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] arr = new int[n][n];

        printKnightsTour(arr, r, c, 1);

        scn.close();
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {

        // Negative case
        if (r < 0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] > 0) {
            return;
        }

        // Pre Node
        chess[r][c] = upcomingMove;
        
        // Base Case
        if (chess.length * chess.length == upcomingMove) {
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1);

        // Post Node
        chess[r][c] = 0; // Backtracking step

    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
