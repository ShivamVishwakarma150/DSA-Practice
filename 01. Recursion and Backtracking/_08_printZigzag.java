import java.util.Scanner;

public class _08_printZigzag {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        printZigzag(n);
        sc.close();
    }

    public static void printZigzag(int n){

        // Base Case
        if(n==1){
            System.out.print("111");
            return;
        }

        // MFE
        System.out.print(n);
        //Faith
        printZigzag(n-1);
        // MFE
        System.out.print(n);
        //Faith
        printZigzag(n-1);
        // MFE
        System.out.print(n);
    }
}
