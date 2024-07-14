import java.util.Scanner;

public class _36_Permutations_2_Item_As_Level {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        permutations(0, n, k, new int[n]);
        sc.close();
    }

    public static void permutations(int currentItem,int n,int k,int[] boxes){
        if(currentItem==k){
            for(int val : boxes) System.out.print(val);
            System.out.println();
            return;
        }

        for(int i=0;i<boxes.length;i++){
            if(boxes[i]==0){
                boxes[i]=currentItem+1;
                permutations(currentItem+1, n, k, boxes);
                boxes[i]=0;
            }
        }
    }


}
