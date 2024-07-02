import java.util.Scanner;

public class _15_lastIndex_O {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        int ans = lastIndex(arr, arr.length - 1, x);
        System.out.println(ans);
        sc.close();

    }

    public static int lastIndex(int[] arr, int idx, int x) {
        // Base Case
        if(idx<0) return -1;
        
        // Faith
        if(arr[idx]==x) return idx;

        // MFE
        int val=lastIndex(arr, idx-1, x);
        return val;
    }
}
