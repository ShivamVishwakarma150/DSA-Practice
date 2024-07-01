import java.util.Scanner;

public class _10_displayArrayReverse {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int []arr=new int[]{3,6,2,5,12,1,15};
        displayArrReverse(arr,0);
        sc.close();
    }

    public static void displayArrReverse(int[]arr,int idx){
        // Base Case
        if(idx==arr.length) return;

        // Faith
        displayArrReverse(arr, idx+1);

        // MFE
        System.out.println(arr[idx]);
    }
}
