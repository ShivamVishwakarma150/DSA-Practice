import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _50_2D_Combiantion_QOL_Item_as_level {

    // This method generates all combinations of placing tq queens on an n x n board
    public static void queensCombinations(int qpsf, int tq, Character[][] chess, int lastQueenRow, int lastQueenCol) {
        // Base case: if the number of queens placed so far equals the total number of queens
        if (qpsf == tq) {
            // Print the current configuration of the chess board
            for (int i = 0; i < tq; i++) {
                for (int j = 0; j < tq; j++) {
                    System.out.print(chess[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        // Try to place the current queen in the remaining cells of the current row
        for (int j = lastQueenCol + 1; j < tq; j++) {
            if (chess[lastQueenRow][j] == '-') { // Check if the cell is empty
                chess[lastQueenRow][j] = 'q'; // Place the queen
                // Recur to place the next queen
                queensCombinations(qpsf + 1, tq, chess, lastQueenRow, j);
                chess[lastQueenRow][j] = '-'; // Backtrack: remove the queen
            }
        }

        // Try to place the current queen in the cells of the subsequent rows
        for (int i = lastQueenRow + 1; i < tq; i++) {
            for (int j = 0; j < tq; j++) {
                if (chess[i][j] == '-') { // Check if the cell is empty
                    chess[i][j] = 'q'; // Place the queen
                    // Recur to place the next queen
                    queensCombinations(qpsf + 1, tq, chess, i, j);
                    chess[i][j] = '-'; // Backtrack: remove the queen
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // Read the board size (n)
        Character[][] chess = new Character[n][n]; // Initialize the chess board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '-'; // Set all cells to empty
            }
        }

        // Start the recursion with no queens placed, on an empty board
        queensCombinations(0, n, chess, 0, -1);
    }
}
