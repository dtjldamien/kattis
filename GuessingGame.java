import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GuessingGame {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int input = Integer.parseInt(br.readLine());
        while (input != 0) {
            String comment = br.readLine();
            int lowerLimit = 0;
            int upperLimit = 11;
            while (!comment.equals("right on")) {
                if (comment.equals("too high")) {
                    upperLimit = Math.min(upperLimit, input);
                } else {
                    lowerLimit = Math.max(lowerLimit, input);
                }
                input = Integer.parseInt(br.readLine());
                comment = br.readLine();
            }
            if (lowerLimit < input && input < upperLimit) {
                pw.println("Stan may be honest");
            } else {
                pw.println("Stan is dishonest");
            }
            input = Integer.parseInt(br.readLine());
        }
        pw.close();
        br.close();
    }
}