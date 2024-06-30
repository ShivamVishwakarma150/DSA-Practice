import java.util.Scanner;

public class _06_powXN_Leetcode_50{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        int n=sc.nextInt();
        System.out.println(myPow(x, n));
        sc.close();
    }

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;

        // Handling Negative Exponent
        long N=n;
        if (N < 0) {
            x = 1 / x;
            N=-N;
        }

        // Faith
        double xpnb2 = myPow(x, (int)(N/2));
        double xpn = (xpnb2 * xpnb2);

        // Meeting Faith With Expectation
        if (N % 2 == 1) {
            xpn = xpn * x;
        }

        return xpn;

    }
}