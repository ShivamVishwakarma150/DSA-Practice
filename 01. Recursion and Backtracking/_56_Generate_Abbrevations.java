import java.util.Scanner;

public class _56_Generate_Abbrevations {
    public static void solution(String str, String asf, int count) {
        // write your code here
        if (str.length() == 0) {
            if (count > 0) {

                System.out.println(asf + count);
            } else {
                System.out.println(asf);
            }

            return;
        }

        //yes
        solution(str.substring(1), count > 0 ? asf + count + str.charAt(0) : asf + str.charAt(0), 0);

        //No
        solution(str.substring(1), asf, ++count);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "", 0);
        scn.close();
    }
}
