// https://open.kattis.com/problems/electricaloutlets
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ElectricalOutlets {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine()); // number of test cases
        for (int i = 0; i < n; i++) {
            String[] testCase = br.readLine().split(" ");
            int k = Integer.parseInt(testCase[0]);
            int numOutlets = 0;
            for (int j = 1; j <= k; j++) {
                numOutlets += Integer.parseInt(testCase[j]);
            }
            numOutlets -= (k - 1);
            pw.println(numOutlets);
        }
        pw.close();
        br.close();
    }
}
