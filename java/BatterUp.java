import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BatterUp {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int score = 0;
        for (int i = 0; i < input.length; i++) {
            int x = Integer.parseInt(input[i]);
            if (x == -1) {
                n--;
            } else {
                score += x;
            }
        }
        pw.println(1.0 * score/n);
        pw.close();
        br.close();
    }
}