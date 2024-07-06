import java.util.Scanner;

public class _24_printKeyPadCombination {
    public static String[] strG=new String[]{".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input = sc.next();
        printKPC(0, input,"");
        sc.close();
    }
    //569
    public static void printKPC(int idx,String input,String output) {
        if(idx==input.length()){
            System.out.println(output);
            return;
        }

        int idxi=input.charAt(idx)-'0';//5
        String stri=strG[idxi];
        for(int i=0;i<stri.length();i++){//mno
            // stri.chatAt(i)-->m
            char ch=stri.charAt(i);
            //Yes
            printKPC(idx+1, input, output+ch);
        }
    }
}
