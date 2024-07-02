import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _16_allIndicies {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
        br.close();

    }

    /*
    While going we maintain a counter using counter variable for element x matched and with that counter we can make array of cuter size and return when it hits to base case.
    and we just retrun that array so that while popping out we can fill that mached x element into that array and finnalyh return it.
    
    */ 
    public static int[] allIndices(int[] arr, int x, int idx, int counter) {

        int []temparr;

        // Base Case
        if(idx==arr.length){
            temparr=new int[counter];
            return temparr;
        }
        
        // MFE -> While going into stack
        if(arr[idx]==x){
            counter++;
        }

        // Faith 
        temparr=allIndices(arr, x, idx+1, counter);

        // MFE -> while popping out from stack
        if(arr[idx]==x){
            temparr[--counter]=idx;
        }
        
        return temparr;

    }

}