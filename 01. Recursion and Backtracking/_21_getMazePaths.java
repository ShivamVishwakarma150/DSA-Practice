import java.util.ArrayList;
import java.util.Scanner;

public class _21_getMazePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dr = sc.nextInt();
        int dc = sc.nextInt();
        ArrayList<String> ans = getMazePaths(0,0,dr-1,dc-1);
        System.out.println(ans);
        sc.close();
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        // Base case
        if(sr==dr && sc==dc){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans=new ArrayList<>();

        if(sr<dr){
            ArrayList<String> smallAns1=getMazePaths(sr+1, sc, dr, dc);
            for(String str :smallAns1){
                ans.add("h"+str);
            }
        }

        if(sc<dc){
            ArrayList<String> smallAns2=getMazePaths(sr, sc+1, dr, dc);
            for(String str:smallAns2){
                ans.add("v"+str);
            }
        }
        

        return ans;
    }
}
