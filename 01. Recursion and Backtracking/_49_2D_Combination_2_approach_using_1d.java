import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _49_2D_Combination_2_approach_using_1d {
     public static void queensCombinations(int qpsf, int tq, int cellNo, String mat) {
        if (cellNo == tq * tq) {
            if (qpsf == tq) {
                System.out.println(mat);
            }
            return;
        }

        if (cellNo % tq == tq - 1) {
            queensCombinations(qpsf + 1, tq, cellNo + 1, mat + 'q' + '\n'); // yes
            queensCombinations(qpsf, tq, cellNo + 1, mat + '-' + '\n');     // no
        } else {
            queensCombinations(qpsf + 1, tq, cellNo + 1, mat + 'q'); // yes
            queensCombinations(qpsf, tq, cellNo + 1, mat + '-');     // no
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensCombinations(0, n, 0, "");
    }
}

/*
 


 */