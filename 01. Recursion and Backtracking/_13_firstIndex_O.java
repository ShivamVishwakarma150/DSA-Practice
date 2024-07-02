import java.util.Scanner;

public class _13_firstIndex_O {
 public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int x=sc.nextInt();
        int ans=firstIndex(arr,0,x);
        System.out.println(ans);
        sc.close();

    }

    public static int firstIndex(int[]arr,int idx,int x){
        if(idx==arr.length) return -1;// Base Case

        // Meeting faith with Expectation
        if(arr[idx]==x) return idx;

        // Faith
        int val=firstIndex(arr, idx+1, x);

        // val==-1 or val
        return val;
    }
}
