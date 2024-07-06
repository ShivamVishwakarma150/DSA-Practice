import java.util.ArrayList;
import java.util.Scanner;

public class _22_getMazePathWithJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dr = sc.nextInt();
        int dc = sc.nextInt();
        ArrayList<String> ans = getMazePaths(0, 0, dr - 1, dc - 1);
        System.out.println(ans);
        sc.close();
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        // Negative Base Case
        if(sr>dr || dr>dc){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }

        // Positive Base case
        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();

        // Horizontal MFE
        int jump=1;
        while(sr+jump<=dr){
            ArrayList<String> smallAns1 = getMazePaths(sr + jump, sc, dr, dc);
            for (String str : smallAns1) {
                ans.add("h" +jump+str);
            }
            jump++;
        }

        
        // Vertical MFE
        jump=1;
        while(sc+jump<=dc){
            ArrayList<String> smallAns3 = getMazePaths(sr, sc + jump, dr, dc);
            for (String str : smallAns3) {
                ans.add("v" +jump+ str);
            }
            jump++;
        }

        // Diagonal MFE
        jump=1;
        while(sc+jump<=dc && sr+jump<=dr){
            ArrayList<String> smallAns2 = getMazePaths(sr + jump, sc+jump, dr, dc);
            for (String str : smallAns2) {
                ans.add("d" +jump+str);
            }
            jump++;
        }

        return ans;
    }
}
