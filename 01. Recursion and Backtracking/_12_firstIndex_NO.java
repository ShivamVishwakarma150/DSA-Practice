import java.util.Scanner;

public class _12_firstIndex_NO {
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

        // Faith
        int val=firstIndex(arr, idx+1, x);

        // Meeting faith with Expectation
        if(val==-1){
            if(arr[idx]==x) return idx;
            else return -1;
        }else{
            if(arr[idx]==x) return idx;
            else return val;
        }
    }
}
