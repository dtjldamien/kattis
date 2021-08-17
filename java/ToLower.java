// https://open.kattis.com/problems/tolower
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ToLower {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]);
        int t = Integer.parseInt(input[1]);
        int numSolved = p;
        for (int i = 0; i < p; i++) {
            boolean isLowerCase = true;
            for (int j = 0; j < t; j++) {
                String testCase = br.readLine();
                for (int idx = 1; idx < testCase.length(); idx++) {
                    if (!Character.isLowerCase(testCase.charAt(idx))) {
                        isLowerCase = false;
                        break;
                    }
                }
            }
            if (!isLowerCase) {
                numSolved--;
            }
        }
        pw.println(numSolved);
        pw.close();
        br.close();
    }
}
