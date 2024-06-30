import java.util.Scanner;

public class _02_printDecreasing {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int que=sc.nextInt();
        printDecreasing(que);
        sc.close();
    }

    public static void printDecreasing(int n){
        // Base Case
        if(n==0) return;

        // Expectation and Extra work to do
        System.out.println(n);
        
        // Faith
        printDecreasing(n-1);

    }
}
