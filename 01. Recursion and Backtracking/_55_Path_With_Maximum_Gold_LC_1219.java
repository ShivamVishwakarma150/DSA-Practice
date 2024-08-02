public class _55_Path_With_Maximum_Gold_LC_1219 {
    

    public static int floodfill(int[][] maze, int sr, int sc, int[] x, int[] y, int asf, boolean[][] vis) {
        // Base case: if out of bounds, cell is blocked, or already visited
        if (sr < 0 || sc < 0 || sr >= maze.length || sc >= maze[0].length || maze[sr][sc] == 0 || vis[sr][sc]) {
            return asf; // Return the sum of the path so far
        }

        vis[sr][sc] = true; // Mark the current cell as visited
        int maxSum = asf; // Initialize the maximum sum for this path

        // Iterate over the possible moves
        for (int i = 0; i < x.length; i++) {
            // Recursive call for each direction, adding the value of the current cell to the sum
            int sum = floodfill(maze, sr + x[i], sc + y[i], x, y, asf + maze[sr][sc], vis);
            maxSum = Math.max(maxSum, sum); // Update the max sum
        }

        vis[sr][sc] = false; // Backtrack and unmark the current cell
        return maxSum;
    }

    // Method to initiate flood fill and find all paths
    public static int findPath(int[][] mat) {
        int[] x = {1, 0, -1, 0}; // Direction vectors for rows (down, up)
        int[] y = {0, 1, 0, -1}; // Direction vectors for columns (right, left)
        boolean[][] vis = new boolean[mat.length][mat[0].length];

        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) { // Start only from non-zero cells
                    maximum = Math.max(maximum, floodfill(mat, i, j, x, y, 0, vis));
                }
            }
        }

        return maximum;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        };

        System.out.println(findPath(mat));
    }
}
