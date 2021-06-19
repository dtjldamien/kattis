// https://open.kattis.com/problems/luhnchecksum
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LuhnChecksum {
        public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String number = br.readLine();
            StringBuilder sb = new StringBuilder(number);
            int idx = number.length() - 2;
            while (idx >= 0) {
                int curr = Character.getNumericValue(number.charAt(idx)) * 2;
                if (curr > 9) {
                    curr = curr / 10 + curr % 10;
                }
                sb.setCharAt(idx, Character.forDigit(curr, 10));
                idx -= 2;
            }
            int sum = 0;
            for (int j = 0; j < sb.length(); j++) {
                sum += Character.getNumericValue(sb.charAt(j));
            }
            if (sum % 10 == 0) {
                pw.println("PASS");
            } else {
                pw.println("FAIL");
            }
        }
        pw.close();
        br.close();
    }
}
