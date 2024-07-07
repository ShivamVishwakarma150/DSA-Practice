import java.util.Scanner;

public class _28_printEncodings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String que=sc.next();
        printEncodings(0,que,"");
        sc.close();
    }
    //4610208
    public static void printEncodings(int idx,String input,String output) {

        // As we can see that input does not change and we are increasing idx+1 on every call so as soon as idx becomes equals to input.length() means we got our ans that's the base case

        // Base Case
        if(input.length()==idx){
            System.out.println(output);
            return;
        }
        

        int one=input.charAt(idx)-'0';//4
        // First number must not zero handled here
        if(one<=9 && one>=1){
            // on every successfull call we are passing idx+1
            printEncodings(idx+1,input, output+(char)('a'+one-1));
        }
        

        // If there is atleas two element.
        if(idx+1<input.length()){

            int two=((input.charAt(idx)-'0')*10)+(input.charAt(idx+1)-'0');//46
            if(two>=10 && two<=26){
                // on every successfull call we are passing idx+1
                printEncodings(idx+2,input, output+(char)('a'+two-1));
            }
        }

    }
}
