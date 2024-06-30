import java.util.Scanner;

public class _03_printDecreasingIncreasing {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int que=sc.nextInt();
        printIncreasingDecreasing(que);
        sc.close();
    }

    public static void printIncreasingDecreasing(int n){
        // Base Case
        if(n==0) return;

        // Expectation and Extra work to do
        System.out.println(n);
        
        // Faith
        printIncreasingDecreasing(n-1);

        // Expectation and Extra work to do
        System.out.println(n);
        
    }
}
