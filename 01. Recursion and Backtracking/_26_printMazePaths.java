import java.util.Scanner;

public class _26_printMazePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dr = sc.nextInt();
        int dc = sc.nextInt();
        printMazePaths(0,0,dr-1,dc-1,"");
        sc.close();
    }
    public static void printMazePaths(int sr, int sc, int dr, int dc, String output) {

        // Negative Base Case
        // sr>dr -> Right Boundry
        // sc>dc -> Down Boundry
        if(sr>dr || sc>dc){
            return;
        }

        // Positive Base Case
        if(sr==dr && sc==dc){
            System.out.println(output);
            return;
        }        


        printMazePaths(sr+1, sc, dr, dc, output+"h");// Horizontal
        printMazePaths(sr, sc+1, dr, dc, output+"v");// Vertical
    }
}
