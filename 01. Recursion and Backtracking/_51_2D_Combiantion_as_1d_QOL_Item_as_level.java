import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _51_2D_Combiantion_as_1d_QOL_Item_as_level {
    // Method to generate all combinations of placing tq queens on an n x n chessboard
    public static void queensCombinations(int qpsf, int tq, Character[][] chess, int lastCellNo) {
        // Base case: when the number of queens placed so far equals the total number of queens
        if (qpsf == tq) {
            // Print the current configuration of the chessboard
            for (int i = 0; i < tq; i++) {
                for (int j = 0; j < tq; j++) {
                    System.out.print(chess[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        // Try to place the current queen in the remaining cells after lastCellNo
        for (int c = lastCellNo + 1; c < tq * tq; c++) {
            int rowNo = c / tq;  // Calculate the row number
            int colNo = c % tq;  // Calculate the column number
            chess[rowNo][colNo] = 'q';  // Place the queen at the calculated position
            // Recur to place the next queen
            queensCombinations(qpsf + 1, tq, chess, c);
            chess[rowNo][colNo] = '-';  // Backtrack: remove the queen
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // Read the board size (n)
        Character[][] chess = new Character[n][n];  // Initialize the chessboard
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '-';  // Set all cells to empty
            }
        }

        // Start the recursion with no queens placed, starting from cell number -1
        queensCombinations(0, n, chess, -1);
    }
}
