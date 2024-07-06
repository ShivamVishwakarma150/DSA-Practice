import java.util.Scanner;

public class _25_printPermutation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input = sc.next();
        printPermutations(input, "");
        sc.close();
    }
    //abc
    public static void printPermutations(String input, String output) {
        if(input.length()==0){
            System.out.println(output);
            return;
        }

        // i=0 -> abc -> printPemutation(0,abc,a);
        // i=1 -> bc-> printPemutation(1,bc,ab);
        // i=2 -> c-> printPemutation(2,c,abc);
        for(int i=0;i<input.length();i++){//abc
            // i-> a
            String nextInput=input.substring(0, i)+input.substring(i+1,input.length());//bc
            printPermutations(nextInput, output+input.charAt(i));
        }
    }
}
