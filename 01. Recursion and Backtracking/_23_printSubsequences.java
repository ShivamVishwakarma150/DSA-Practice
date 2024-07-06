import java.util.Scanner;

public class _23_printSubsequences {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        printSS(0, str,"");
        sc.close();
    }
    public static void printSS(int idx, String str,String output) {
        // // Base Case
        if(idx==str.length()){
            System.out.println(output);
            return;
        }
        
        char ch=str.charAt(idx);

        //MFE
        // Yes
        printSS(idx+1, str, output+ch);
        //No
        printSS(idx+1, str, output);

    }
}
