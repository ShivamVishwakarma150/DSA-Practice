import java.util.ArrayList;
import java.util.Scanner;

public class _19_getStairPath_NO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans);
        sc.close();
    }
    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }else if(n<0){
            ArrayList<String> base=new ArrayList<>();
            return base;
        }

        ArrayList<String> smallAns1=getStairPaths(n-1);
        ArrayList<String> smallAns2=getStairPaths(n-2);
        ArrayList<String> smallAns3=getStairPaths(n-3);

        ArrayList<String> ans=new ArrayList<>();

        for(String str:smallAns1){
            ans.add("1"+str);
        }
        for(String str:smallAns2){
            ans.add("2"+str);
        }
        for(String str:smallAns3){
            ans.add("3"+str);
        }
        

        return ans;
    }
}
