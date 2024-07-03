import java.util.ArrayList;
import java.util.Scanner;

public class _18_getKeyPadCombinations {
    
    public static String[] str=new String[]{".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> ans = getKPC(0, str);
        System.out.println(ans);

        sc.close();

    }

    public static ArrayList<String> getKPC(int idx,String strf) {
        // Base Case
        if(strf.length()==idx){
            ArrayList<String> temp=new ArrayList<>();
            temp.add("");
            return temp;
        }

        // Faith
        ArrayList<String> subAns=getKPC(idx+1, strf);

        //MFE
        ArrayList<String> ans=new ArrayList<>();
        String tempSt=str[strf.charAt(idx)-'0'];
        for (String subans : subAns) {
            for (int i = 0; i < tempSt.length(); i++) {
                ans.add(tempSt.charAt(i)+subans);
            }
        }

        //return
        return ans;
    }

}
