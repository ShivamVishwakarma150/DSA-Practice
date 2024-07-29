import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _48_2D_Combination_1{
    // qpsf -> Queens placed so far, tq -> total Queens
    public static void queensCombinations(int qpsf, int tq, int row, int col, String mat) {
        if (row == tq) {
            if (qpsf == tq) {
                System.out.println(mat);
            }
            return;
        }

        if (col == tq - 1) {
            // If it's the last column in the current row, move to the next row
            queensCombinations(qpsf + 1, tq, row + 1, 0, mat + 'q' + '\n'); // place queen
            queensCombinations(qpsf, tq, row + 1, 0, mat + '-' + '\n'); // don't place queen
        } else {
            queensCombinations(qpsf + 1, tq, row, col + 1, mat + 'q'); // place queen
            queensCombinations(qpsf, tq, row, col + 1, mat + '-'); // don't place queen
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensCombinations(0, n, 0, 0, "");
    }
}

/* 
The function queensCombinations generates these combinations by iterating through each cell of the board and deciding whether to place a queen ('q') or leave the cell empty ('-'). The parameters used are:

    qpsf: Queens placed so far
    tq: Total queens (which matches the total number of cells in the board)
    row: Current row in the board
    col: Current column in the board
    mat: Current board configuration represented as a string

The base case of the recursion is when row equals tq, indicating that the function has processed all rows of the board. If qpsf equals tq, the function prints the configuration.

 */