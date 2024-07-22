import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _42_K_words_3_Repitition_Allowed_Box_on_Level {
  
  
  public static void combination(int currentChar,String ustr,HashMap<Character,Integer> freq,String res,int k){

    // Base Case
    if(res.length()==k){
      System.out.println(res);
      return;
    }

    // Negative Base Case
    if(currentChar==ustr.length()){
      return;
    }

    // Get frequency of each character
    // Because on each level we need
    // ie aabbbc -> a2,b3,c1
    // for first time for a val=2
    int val=freq.get(ustr.charAt(currentChar));
    for(int i=val;i>=0;i--){

      //unique case
      if(i+res.length()>k){
        continue;
      }


      // for one case where after a,  b is for three times abbb and that to within level
      String newRes=res;
      for(int j=1;j<=i;j++){
        newRes+=ustr.charAt(currentChar);
      }

      combination(currentChar+1, ustr, freq, newRes, k);
    }

      

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    // aabbbc -> a2b3c1 -> ustr=abc
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }

    combination(0,ustr,unique,"",k);
  }

}
