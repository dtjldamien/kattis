
// https://open.kattis.com/problems/drunkvigenere
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Patuljci {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int[] hats = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            hats[i] = Integer.parseInt(br.readLine());
            sum += hats[i];
        }
        boolean hasFound = false;
        int firstImposter = 10;
        int secondImposter = 10;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - hats[i] - hats[j] == 100) {
                    hasFound = true;
                    firstImposter = i;
                    secondImposter = j;
                    break;
                }
            }
            if (hasFound) {
                break;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i != firstImposter && i != secondImposter) {
                pw.println(hats[i]);
            }
        }
        pw.close();
        br.close();
    }
}
