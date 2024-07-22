import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class _41_K_Words_Repitition_Not_Allowed{
    public static void combinations(ArrayList<Character> chs,int lastIdx,String asf,int k){

        if(k==asf.length()){
            System.out.println(asf);
            return;
        }

        for(int i=lastIdx+1;i<chs.size();i++){
            combinations(chs, i, asf+chs.get(i), k);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int k=sc.nextInt();

        HashSet<Character> uniq=new HashSet<>();
        ArrayList<Character> chs=new ArrayList<>();

        // Removing duplicates and preparing the character list
        for(int i=0;i<str.length();i++){
            if(!uniq.contains(str.charAt(i))){
                chs.add(str.charAt(i));
            }
            uniq.add(str.charAt(i));
        }

        combinations(chs,-1,"",k);
        sc.close();
    }
}