import java.util.Scanner;

public class _38_Combinations_Item_As_Level {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        combinations(0, n, k, new int[n], -1);
        sc.close();
    }

    public static void combinations(int currentItem, int n, int k, int[] boxes, int lastItemIndex) {
        if (currentItem == k) {
            for (int val : boxes) {
                if (val == 0)
                    System.out.print("_");
                else
                    System.out.print("i");
            }
            System.out.println();
            return;
        }

        for (int i = lastItemIndex + 1; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = currentItem + 1;
                combinations(currentItem + 1, n, k, boxes, i);
                boxes[i] = 0;
            }
        }
    }
}
