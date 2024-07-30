import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _52_2D_Permutation_as_1d_Box_on_Level {
    
    // Method to generate queen permutations
    public static void queensPermutations(int qpsf, int tq, int cellNo, String mat, boolean[] vis) {
        // Base case: if all cells are processed
        if (cellNo == tq * tq) {
            if (qpsf == tq) {
                System.out.println(mat);
                System.out.println();
            }
            return;
        }

        // If we're at the last cell of the current row
        if (cellNo % tq == tq - 1) { 
            for (int i = 0; i < tq; i++) {
                if (vis[i]==false) { // Check if queen i is placed

                    vis[i] = true;

                    // Place queen i+1 at current cell, go to next row
                    queensPermutations(qpsf + 1, tq, cellNo + 1, mat + "q" + (i + 1) + "\t\n", vis);

                    vis[i] = false; // Backtrack
                }
            }
            // Place empty cell at end of row, go to next row
            queensPermutations(qpsf, tq, cellNo + 1, mat + "-\t\n", vis);
        } 

        // cells that are not at the end of a row
        else {
            for (int i = 0; i < tq; i++) {
                if (vis[i]==false) {

                    vis[i] = true;

                    // Place queen i+1 at current cell, continue in same row
                    queensPermutations(qpsf + 1, tq, cellNo + 1, mat + "q" + (i + 1) + "\t", vis);

                    vis[i] = false; // Backtrack
                }
            }
            // Place empty cell, continue in same row
            queensPermutations(qpsf, tq, cellNo + 1, mat + "-\t", vis);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // Read number of queens
        boolean[] queens = new boolean[n]; // Array to track placed queens
        queensPermutations(0, n, 0, "", queens); // Start generating permutations
    }
}
