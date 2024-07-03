import java.util.*;

public class _17_getSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        ArrayList<String> ans = gss(0, st);
        System.out.println(ans);

        sc.close();

    }

    public static ArrayList<String> gss(int idx, String str) {
        // Base Case
        if (str.length() == idx) {
            ArrayList<String> st = new ArrayList<>();
            st.add("");
            return st;
        }

        // Faith
        ArrayList<String> smallSub = gss(idx + 1, str);

        // MFE
        ArrayList<String> ans = new ArrayList<>();
        for (String itr : smallSub) {
            ans.add(itr);
        }
        for (String itr : smallSub) {
            ans.add(str.charAt(idx) + itr);
        }

        // return
        return ans;
    }

}