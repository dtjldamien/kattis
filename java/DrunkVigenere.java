
// https://open.kattis.com/problems/drunkvigenere
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DrunkVigenere {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String C = br.readLine();
        String K = br.readLine();
        for (int i = 0; i < C.length(); i++) {
            if (i % 2 == 0) {
                int curr = C.charAt(i) - K.charAt(i) + 'A';
                if (curr > 'Z') {
                    curr = curr - 'Z' + 'A' - 1;
                } else if (curr < 'A') {
                    curr = 'Z' + 1 - ('A' - curr);
                }
                pw.print((char) curr);
            } else {
                int curr = C.charAt(i) + K.charAt(i) - 'A';
                if (curr > 'Z') {
                    curr = curr - 'Z' + 'A' - 1;
                } else if (curr < 'A') {
                    curr = 'Z' + 1 - ('A' - curr);
                }
                pw.print((char) curr);
            }
        }
        pw.close();
        br.close();
    }
}
