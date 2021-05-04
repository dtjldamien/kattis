
// https://open.kattis.com/problems/oktalni
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Oktalni {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String binary = br.readLine();
        String octal = "";
        for (int i = binary.length() - 1; i >= 0; i = i - 3) {
            int currentSum = 0;
            if (i >= 0) {
                if (binary.charAt(i) == '1') {
                    currentSum += 1;
                }
            }
            if (i >= 1) {
                if (binary.charAt(i - 1) == '1') {
                    currentSum += 2;
                }
            }
            if (i >= 2) {
                if (binary.charAt(i - 2) == '1') {
                    currentSum += 4;
                }    
            }
            octal = currentSum + octal;
        }
        pw.println(octal);
        pw.close();
        br.close();
    }
}
