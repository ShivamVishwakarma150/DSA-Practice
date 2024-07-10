## My code
```java
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
```

### Analysis

Your code implements a solution to the Knight's Tour problem using backtracking. The Knight's Tour is a sequence of moves of a knight on a chessboard such that the knight visits every square exactly once.

1. **Main Method**:
    - Reads the size of the board (`n`) and the starting position (`r`, `c`) from the user.
    - Initializes an `n x n` board with all zeros.
    - Calls `printKnightsTour` to find and print all possible tours starting from the given position.

2. **`printKnightsTour` Method**:
    - **Negative Case**: Checks if the knight is out of bounds or revisits a square. If so, it returns immediately.
    - **Base Case**: If the `upcomingMove` equals the total number of squares (i.e., the knight has visited all squares), it prints the board.
    - **Recursive Calls**: Moves the knight to all possible positions and calls `printKnightsTour` recursively for each valid move.
    - **Backtracking**: Resets the current square to zero after exploring all possible moves from it (backtracking step).

3. **`displayBoard` Method**:
    - Prints the current state of the board.

### Enhancements

- **Input Validation**: Add checks to ensure the inputs are within valid ranges.
- **Efficiency Improvements**: Implement Warnsdorff's rule for more efficient solution finding.
- **Board Printing**: Enhance the board display for better readability.

Here's the updated code with some minor improvements:

```java
import java.util.Scanner;

public class KnightTour {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter board size:");
        int n = scn.nextInt();
        System.out.println("Enter starting row and column:");
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] board = new int[n][n];

        printKnightsTour(board, r, c, 1);

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
            chess[r][c] = 0; // Backtracking step
            return;
        }

        // Possible moves of the knight
        int[] rowMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < 8; i++) {
            printKnightsTour(chess, r + rowMoves[i], c + colMoves[i], upcomingMove + 1);
        }

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
```

### Key Improvements:
- **Code Cleanup**: Removed repetitive code by using arrays for knight moves.
- **User Guidance**: Added prompts for user input.
- **Efficiency**: More efficient code structure for readability.

This code maintains the original functionality while being cleaner and more efficient.