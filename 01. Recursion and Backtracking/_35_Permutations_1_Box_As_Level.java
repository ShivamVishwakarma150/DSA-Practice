/**
1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

0 < nboxes <= 10
0 <= ritems <= nboxes

 */

import java.util.Scanner;

public class _35_Permutations_1_Box_As_Level {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        String boxes="";
        boolean[] itemPlaced= new boolean[k];
        permutations(0, n, k, itemPlaced, boxes, 0);
        sc.close();
    }

    public static void permutations(int currentBox,int n,int k,boolean[] itemPlaced,String boxes,int itemPlacedCount){
        if(currentBox==n){
            if(itemPlacedCount==k){
                System.out.println(boxes);
            }

            return;
        }


        // When we place element
        for(int i=0;i<k;i++){
            if(itemPlaced[i]==false){
                itemPlaced[i]=true;
                permutations(currentBox+1, n, k, itemPlaced, boxes+(i+1), itemPlacedCount+1);
                itemPlaced[i]=false;
            }
        }


        // currentBox -> Do not place any element
        permutations(currentBox+1, n, k, itemPlaced, boxes+0, itemPlacedCount);

    }
}
