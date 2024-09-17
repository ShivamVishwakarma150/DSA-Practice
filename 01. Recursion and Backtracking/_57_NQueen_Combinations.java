import java.util.*;
public class _57_NQueen_Combinations {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        nqueen(n);
        sc.close();
    }

    static List<List<String>> res;

    public static boolean isQueenSafe(int row,int col,boolean[][]chess){

        //row(left)
        for(int j=0;j<col;j++){
            if(chess[row][j]==true){
                return false;
            }
        }

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

    public static void nqueen(int r,int c,int qpsf,boolean[][] vis){
        if(qpsf==vis.length){
            List<String> ans=new ArrayList<>();
            for(int i=0;i<vis.length;i++){
                String curr="";
                for(int j=0;j<vis.length;j++){
                    if(vis[i][j] == true){
                        curr = curr + "Q";
                    }else{
                        curr = curr+".";
                    }
                }
                ans.add(curr);
            }
            res.add(ans);
            return;
        }

        // Edge Case or Base
        if(r==vis.length){
            return;
        }

        if(isQueenSafe(r, c, vis)){
            vis[r][c] = true;

            if(c==vis.length-1){
                nqueen(r+1, 0, qpsf+1, vis);
            }else{
                nqueen(r, c+1, qpsf+1, vis);

            }

            vis[r][c] = false;
        }
        if(c==vis.length-1){
            nqueen(r+1, 0, qpsf+1, vis);
        }else{
            nqueen(r, c+1, qpsf+1, vis);

        }


    }

    public static List<List<String>> nqueen(int n){
        res = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];

        nqueen(0,0,0,vis);
        return res;
    }

}
