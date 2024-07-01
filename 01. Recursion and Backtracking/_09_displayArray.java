import java.util.Scanner;

public class _09_displayArray {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int []arr=new int[]{3,6,2,5,12,1,15};
        displayArr(arr,0);
        sc.close();
    }

    public static void displayArr(int[]arr,int idx){
        // Base Case
        if(idx==arr.length) return;

        // MFE
        System.out.println(arr[idx]);

        // Faith
        displayArr(arr, idx+1);
    }
}
