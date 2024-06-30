import java.util.Scanner;

public class _05_printLogrithmic {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(powerLogrithmic(x, n));
        sc.close();
    }

    public static int powerLogrithmic(int x, int n){
        // Base Case
        if(n==0) return 1;

        // Faith x^n/2
        int xpn1=powerLogrithmic(x, n/2);

        // X^n = x^n/2 * x^n/2
        int xpn = xpn1 * xpn1;

        // If n is odd
        if(n%2==1) xpn*=x;

        // return
        return xpn;

    }
}
