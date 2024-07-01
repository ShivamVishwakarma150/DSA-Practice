import java.util.Scanner;

public class _11_maxOfArray {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int []arr=new int[]{3,6,2,5,12,1,15};
        System.out.println(maxOfArray(arr,0));
        sc.close();
        
    }
    public static int maxOfArray(int[]arr,int idx){
        // Base Case 
        if(idx==arr.length) return Integer.MIN_VALUE;
        // if(idx==arr.length-1) return arr[idx];

        // Faith
        int val=maxOfArray(arr, idx+1);
        
        // MFE
        int max=Math.max(arr[idx],val);
        //int max=arr[idx]>val?arr[idx]:val;

        return max;

    }
}
