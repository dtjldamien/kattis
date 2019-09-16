import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LastFactorialDigit {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int x = Integer.parseInt(br.readLine());
            int factorial = 1;
            for (int j = 1; j <= x; j++) {
                factorial *= j;
            }
            pw.println(factorial % 10);
        }
        pw.close();
        br.close();
    }
}