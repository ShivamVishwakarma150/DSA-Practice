import java.util.Scanner;

public class _14_lastIndex_NO {
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int x=sc.nextInt();
        int ans=lastIndex(arr,arr.length-1,x);
        System.out.println(ans);
        sc.close();

    }

    public static int lastIndex(int[]arr,int idx,int x){
        if(idx<0) return -1;// Base Case
        
        int val=lastIndex(arr, idx-1, x);// Faith
        
        // MFE
        if(val==-1){
            if(arr[idx]==x) return idx;
            else return -1;
        }else{
            if(arr[idx]==x) return idx;
            return val;
        }
    }
}
