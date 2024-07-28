import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _45_K_Length_Word_Repititon_Allowed_BOL {
    
    public static void permutation(String res,String ustr,HashMap<Character,Integer> unique,int k){
        if(res.length()==k){
            System.out.println(res);
            return;
        }

        for(Character ch:ustr.toCharArray()){
            int oldFreq=unique.get(ch);
            if(oldFreq>0){
                unique.put(ch,oldFreq-1);
                permutation(res+ch, ustr, unique, k);
                unique.put(ch,oldFreq);
            }
        }
    }


    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character,Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch,1);
        ustr += ch;
      }else{
        unique.put(ch,unique.get(ch)+1);
      }
    }

    permutation("", ustr, unique, k);


   
  }
}
