// https://open.kattis.com/problems/compromise
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Compromise {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] testScenario = br.readLine().split(" ");
            int n = Integer.parseInt(testScenario[0]);
            int m = Integer.parseInt(testScenario[1]);
            int[] count = new int[m];
            for (int j = 0; j < n; j++) {
                String input = br.readLine();
                for (int k = 0; k < m; k++) {
                    if (input.charAt(k) == '1') {
                        count[k]++;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < m; k++) {
                if (count[k] > n / 2) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            pw.println(sb.toString());
        }
        pw.close();
        br.close();
    }
}
