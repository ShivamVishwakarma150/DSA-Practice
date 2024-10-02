import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _58_NQueen_Permutation {

    public static boolean isQueenSafe(int row, int col, boolean[][] chess) {

        // row(left)
        for (int j = 0; j < col; j++) {
            if (chess[row][j] == true) {
                return false;
            }
        }

        // upward column
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == true) {
                return false;
            }
        }

        // upward left Diagonal
        int i = row, j = col;
        while (i >= 0 && j >= 0) {
            if (chess[i][j] == true) {
                return false;
            }

            i--;
            j--;
        }

        // Upward Right Diagonal
        i = row;
        j = col;

        while (i >= 0 && j < chess[0].length) {
            if (chess[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void nqueens(int qpsf, int r, int c, boolean[] queenPlaced, int[][] chess) {
        int n = queenPlaced.length;
        
        if (qpsf == n) {  // All queens placed successfully
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(chess[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
    
        if (r == n) {  // If reached the end of the board
            return;
        }
    
        if (c == n - 1) {  // Move to the next row
            nqueens(qpsf, r + 1, 0, queenPlaced, chess);
        } else {
            nqueens(qpsf, r, c + 1, queenPlaced, chess);  // Try placing queen in next column
        }
    
        // Try placing a queen in the current row and column if it's safe
        for (int i = 0; i < n; i++) {
            if (!queenPlaced[i] ){// && // isQueenSafe(r, c, chess)) {
                queenPlaced[i] = true;
                chess[r][c] = i + 1;
    
                if (c == n - 1) {
                    nqueens(qpsf + 1, r + 1, 0, queenPlaced, chess);
                } else {
                    nqueens(qpsf + 1, r, c + 1, queenPlaced, chess);
                }
    
                // Backtrack
                chess[r][c] = 0;
                queenPlaced[i] = false;
            }
        }
    }
    

    public static void nqueen(int r, int c, int qpsf, boolean[][] vis) {

    }

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        // write your code here

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}
