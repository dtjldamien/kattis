
// https://open.kattis.com/problems/methodicmultiplication
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.StringBuilder;

public class MethodicMultiplication {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String input1 = br.readLine();
        String input2 = br.readLine();
        int result = countS(input1) * countS(input2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result; i++) {
            sb.append("S(");
        }
        sb.append("0");
        for (int i = 0; i < result; i++) {
            sb.append(")");
        }
        pw.println(sb.toString());
        pw.close();
        br.close();
    }

    public static int countS(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'S') {
                count++;
            }
        }
        return count;
    }
}
