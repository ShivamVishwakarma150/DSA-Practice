import java.util.Scanner;

public class _01_printIncreasing {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int que=sc.nextInt();
        printIncreasing(que);
        sc.close();
    }

    public static void printIncreasing(int n){
        // Base Case
        if(n==0) return;

        // Faith
        printIncreasing(n-1);

        // Expectation and Extra work to do
        System.out.println(n);
    }


}
