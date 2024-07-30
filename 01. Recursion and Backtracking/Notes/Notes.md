# K words Permutation Repitition not Allowed - 1
![alt text](image.png)

# K words Permutation Repitition not Allowed - 2
![alt text](image-1.png)

# Coin change Combinations sum-2 Finite Supply
![alt text](image-2.png)

# coin change | Combinations sum 1 Infinite supply
![alt text](image-3.png)

# 2d Combinations - 1 (Box on Level)
![alt text](image-4.png)

# 2d Combination - 2 using 1d conecpt
![alt text](image-5.png)

### Corrections and Explanations

1. **Parameters:**
   - `qpsf`: Queens placed so far.
   - `tq`: Total queens (or total cells, since every cell can be occupied by 'q' or '-').
   - `cellNo`: The current cell number being processed.
   - `mat`: The string that stores the current configuration of the board.

2. **Logic:**
   - The base case checks if `cellNo` equals `tq * tq`. This condition checks if we've processed all cells in the board. If `qpsf` equals `tq`, it means we've placed queens in all cells. The code prints the current configuration `mat`.

   - The next `if` statement checks if the current cell is the last in its row using the condition `cellNo % tq == tq - 1`. If true, it means we need to move to the next row. The recursion calls in this block:
     - `queensCombinations(qpsf + 1, tq, cellNo + 1, mat + 'q' + '\n');` places a 'q' and moves to the next cell.
     - `queensCombinations(qpsf, tq, cellNo + 1, mat + '-' + '\n');` places a '-' and moves to the next cell.

   - The `else` block handles the case where we're not at the end of the row:
     - `queensCombinations(qpsf + 1, tq, cellNo + 1, mat + 'q');` places a 'q' without adding a newline.
     - `queensCombinations(qpsf, tq, cellNo + 1, mat + '-');` places a '-' without adding a newline.

3. **Code Snippet:**
   ```java
   import java.io.*;
   import java.util.*;

   public class Main {
       public static void queensCombinations(int qpsf, int tq, int cellNo, String mat) {
           if (cellNo == tq * tq) {
               if (qpsf == tq) {
                   System.out.println(mat);
               }
               return;
           }

           if (cellNo % tq == tq - 1) {
               queensCombinations(qpsf + 1, tq, cellNo + 1, mat + 'q' + '\n'); // yes
               queensCombinations(qpsf, tq, cellNo + 1, mat + '-' + '\n');     // no
           } else {
               queensCombinations(qpsf + 1, tq, cellNo + 1, mat + 'q'); // yes
               queensCombinations(qpsf, tq, cellNo + 1, mat + '-');     // no
           }
       }

       public static void main(String[] args) throws Exception {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           int n = Integer.parseInt(br.readLine());

           queensCombinations(0, n, 0, "");
       }
   }
   ```

### Notes:
- The code reads `n` as the size of the board and `tq` as the total number of cells on the board (`n * n`).
- This setup allows the generation of all possible configurations of 'q' and '-' on an `n x n` board.
- It seems like the `qpsf` is used more for counting the cells processed rather than tracking the number of queens placed. The board configurations are simply about filling cells with either 'q' or '-'.

The logic behind using a single `cellNo` parameter instead of separate `row` and `column` parameters is to simplify the traversal of the 2D board in a 1D manner. Here's how these conditions work:

### `cellNo` Concept
In a traditional 2D array or matrix traversal, you have two indices: `row` and `column`. However, you can linearize these indices into a single index `cellNo` by considering the 2D grid as a flattened 1D array. This approach helps in iterating over the board cells in a straightforward manner, and it can also simplify recursive function calls.

### `cellNo == tq * tq`
- **Condition:** This checks if all the cells in the `n x n` board have been processed.
- **Explanation:** If `tq` represents the number of rows or columns (i.e., the size of the board), then the total number of cells in the board is `tq * tq` (since the board is `tq` rows by `tq` columns). When `cellNo` reaches this value, it means we have processed all the cells, and the recursion should stop.

### `cellNo % tq == tq - 1`
- **Condition:** This checks if the current `cellNo` corresponds to the last column of a row in the 2D grid.
- **Explanation:** In a flattened 1D view of the board, the last column in any row will have a `cellNo` that, when divided by `tq`, leaves a remainder of `tq - 1`. For example, if `tq` is 4 (for a 4x4 board), then the last column in each row will have `cellNo` values of 3, 7, 11, 15 (i.e., `tq - 1`, `2*tq - 1`, `3*tq - 1`, etc.). The condition `cellNo % tq == tq - 1` captures these cases, indicating that the next recursive call should start a new line (row) in the `mat` string representation of the board.

### Advantages of This Approach
1. **Simplicity:** Using a single `cellNo` reduces the number of parameters and makes the recursive calls simpler.
2. **Clarity:** It avoids the need for manual row and column calculations or increments, as the traversal is handled uniformly by incrementing `cellNo`.
3. **Generalization:** This method is easily adaptable to other grid-based problems where the grid can be flattened into a 1D array.

In summary, this approach linearizes the board traversal, making the implementation more straightforward and avoiding the complexity of managing two separate indices (`row` and `column`). The specific conditions (`cellNo == tq * tq` and `cellNo % tq == tq - 1`) are used to manage the end-of-board and end-of-row scenarios, respectively.