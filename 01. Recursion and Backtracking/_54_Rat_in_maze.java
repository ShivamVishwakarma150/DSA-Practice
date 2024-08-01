import java.util.ArrayList;

public class _54_Rat_in_maze {
    public static void floodfill(int[][] maze, int sr, int sc, int[] x, int[] y, char[] ch, String asf, boolean[][] vis, ArrayList<String> ans) {
        int dr = maze.length - 1;  // Destination row index
        int dc = maze[0].length - 1;  // Destination column index

        // Base case: if out of bounds, cell is blocked, or already visited
        if (sr > dr || sc > dc || sr < 0 || sc < 0 || maze[sr][sc] == 0 || vis[sr][sc] == true) {
            return; // Terminate this path
        }

        // Base case: reached the destination
        if (sr == dr && sc == dc) {
            ans.add(asf); // Add the path to the list of answers
            return;
        }

        vis[sr][sc] = true; // Mark the current cell as visited

        // Iterate over the possible moves
        for (int i = 0; i < x.length; i++) {
            // Recursive call for each direction
            floodfill(maze, sr + x[i], sc + y[i], x, y, ch, asf + ch[i], vis, ans);
        }

        vis[sr][sc] = false; // Backtrack and unmark the current cell
    }

    // Method to initiate flood fill and find all paths
    public static ArrayList<String> findPath(int[][] mat) {
        int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns
        boolean[][] vis = new boolean[n][m]; // Visited array
        int[] x = new int[]{-1, 0, 1, 0}; // Row direction offsets for U, L, D, R
        int[] y = new int[]{0, -1, 0, 1}; // Column direction offsets for U, L, D, R
        char[] ch = new char[]{'U', 'L', 'D', 'R'}; // Directions corresponding to the offsets
        ArrayList<String> ans = new ArrayList<String>(); // List to store the paths

        // Start flood fill from the top-left corner
        floodfill(mat, 0, 0, x, y, ch, "", vis, ans);

        return ans; // Return the list of paths
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        ArrayList<String> paths = findPath(mat);
        System.out.println(paths);
    }
}
