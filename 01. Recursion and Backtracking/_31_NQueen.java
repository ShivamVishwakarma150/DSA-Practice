import java.util.Scanner;

public class _31_NQueen {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] arr = new boolean[n][n];

        printNQueens(arr,"",0);
        scn.close();
    }


    // Sample input 
    // 4
    // Sample output
    // 0-1, 1-3, 2-0, 3-2, .
    // 0-2, 1-0, 2-3, 3-1, .
    public static void printNQueens(boolean[][] chess, String qsf, int row) {

        if(row==chess.length){
            System.out.println(qsf+".");
            return;
        }

        for(int col=0;col<chess[0].length;col++){
            if(isQueenSafe(chess, row, col)==true){
                // pre edge
                chess[row][col] = true;

                printNQueens(chess, qsf+row+"-"+col+", ", row+1);
                
                // post edge
                chess[row][col] = false;
            }
        }

    }

    public static boolean isQueenSafe(boolean[][] chess,int row,int col){
        // upward column
        for(int i=0;i<row;i++){
            if(chess[i][col]==true){
                return false;
            }
        }

        // upward left Diagonal 
        int i=row,j=col;
        while(i>=0 && j>=0){
            if(chess[i][j]==true){
                return false;
            }

            i--; j--;
        }

        // Upward Right Diagonal
        i=row;
        j=col;

        while(i>=0 && j<chess[0].length){
            if(chess[i][j]==true){
                return false;
            }
            i--; j++;
        }


        return true;
    }
}
