package java;

// https://open.kattis.com/problems/runlengthencodingrun
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RunLengthEncodingRun {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        if (input[0].equals("E")) {
            // encode
            char[] decoded = input[1].toCharArray();
            StringBuilder sb = new StringBuilder(decoded[0]);
            int count = 1;
            for (int i = 1; i < decoded.length; i++) {
                if (decoded[i] == decoded[i - 1]) {
                    count++;
                } else {
                    sb.append(decoded[i - 1]);
                    sb.append(count);
                    count = 1;
                }
            }
            sb.append(decoded[decoded.length - 1]);
            sb.append(count);
            pw.println(sb.toString());
        } else {
            // decode
            char[] encoded = input[1].toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < encoded.length; i = i + 2) {
                char curr = encoded[i];
                int count = Character.getNumericValue(encoded[i + 1]);
                for (int j = 0; j < count; j++) {
                    sb.append(curr);
                }
            }
            pw.println(sb.toString());
        }
        pw.close();
        br.close();
    }
}
