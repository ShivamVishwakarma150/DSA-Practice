import java.util.Scanner;

public class _07_towerOfHanoi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,t1,t2,t3;
        n=sc.nextInt();
        t1=sc.nextInt();
        t2=sc.nextInt();
        t3=sc.nextInt();
        TOH(n, t1, t2, t3);
        sc.close();
    }

    public static void TOH(int n,int t1,int t2,int t3){
        // Base Case
        if(n==0) return;

        // Faith n-1 do it properly moves t1 to t3 using t2 as aux
        TOH(n-1,t1,t3,t2);

        // Expectation (move nth Disk from t1 to t2)
        System.out.println(n+"["+t1+"->"+t2+"]");

        // Faith n-1 back t3 to t2 using t1 as aux
        TOH(n-1,t3,t2,t1);
    }
}
