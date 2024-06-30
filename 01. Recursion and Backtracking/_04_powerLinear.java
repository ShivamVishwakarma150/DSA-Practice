import java.util.Scanner;

public class _04_powerLinear {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(powerLinear(x, n));
        sc.close();
    }

    public static int powerLinear(int x,int n){
        // Base Case : x^0=1
        if(n==0) return 1;

        // 1. Calculated x^n-1 using Faith
        int xpn1=powerLinear(x, n-1);

        // 2. Calculated x^n using x^n-1
        int xpn=xpn1*x;

        //3. Calculate x^n
        return xpn;

    }
}
