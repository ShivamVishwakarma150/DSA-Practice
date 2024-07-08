import java.util.Scanner;

public class _29_targetSumSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int tar=sc.nextInt();
        printTargetSumSubsets(arr,0,"",tar);
        sc.close();

    }

    // Solved by me
    public static void printTargetSumSubsets(int[] arr, int idx, String output, int rem) {

        // base case
        if(rem==0){
            System.out.println(output+".");
            return;
        }

        // pruning case
        if(rem<0){
            return;
        }

        // MFE
        if(idx<arr.length){
            printTargetSumSubsets(arr, idx+1, output+arr[idx]+",", rem-arr[idx]);
            
            printTargetSumSubsets(arr, idx+1, output, rem);
        }
    }

    // Solved by instructor
    public static void printTargetSumSubsets2(int[] arr, int idx, String output, int rem) {
        // base Case
        if (idx == arr.length) {
            if (rem == 0) {
                System.out.println(output + ".");
            }
            return;
        }

        // Pruning Case
        if (rem < 0) {
            return;
        }

        //MFE
        printTargetSumSubsets2(arr, idx + 1, output + arr[idx] + ",", rem - arr[idx]);
        printTargetSumSubsets2(arr, idx + 1, output, rem);
    }
    
}
