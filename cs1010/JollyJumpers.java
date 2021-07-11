// https://open.kattis.com/problems/jollyjumpers
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class JollyJumpers {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String inputString = "";
        while ((inputString = br.readLine()) != null) {
            String[] elements = inputString.split(" ");
            int n = Integer.parseInt(elements[0]);
            boolean[] hasDifference = new boolean[n];
            boolean isJolly = true;
            for (int i = 2; i <= n; i++) {
                int prev = Integer.parseInt(elements[i - 1]);
                int curr = Integer.parseInt(elements[i]);
                int difference = Math.abs(prev - curr);
                if (difference < n) {
                    hasDifference[difference] = true;
                }
            }
            for (int i = 1; i < n; i++) {
                if (!hasDifference[i]) {
                    isJolly = false;
                    break;
                }
            }
            if (isJolly) {
                pw.println("Jolly");
            } else {
                pw.println("Not Jolly");
            }
        }
        pw.close();
        br.close();
    }
}
