import java.util.Scanner;

public class _27_printStairPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStairPaths(n,"");
        sc.close();
    }
    public static void printStairPaths(int n, String path) {
        // Negative Base Case
        if(n<0){
            return;
        }

        // Positive Base Case
        if(n==0){
            System.out.println(path);
            return;
        }

        // MFE
        printStairPaths(n-1, path+"1");
        printStairPaths(n-2, path+"2");
        printStairPaths(n-3, path+"3");
    }
}
