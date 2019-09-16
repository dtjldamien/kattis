import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class JudgingMoose {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int left = Integer.parseInt(input[0]);
        int right = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        if (left + right == 0) {
            sb.append("Not a moose");
        } else if (left == right) {
            sb.append("Even ");
            sb.append(2 * left);
        } else {
            sb.append("Odd ");
            int points = (int) Math.max(left, right) * 2;
            sb.append(points);
        }
        pw.println(sb.toString());
        pw.close();
        br.close();
    }
}