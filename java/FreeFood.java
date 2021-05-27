
// https://open.kattis.com/problems/freefood
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FreeFood {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        int[] calendar = new int[365];
        int numDays = 0;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]) - 1;
            int t = Integer.parseInt(input[1]) - 1;
            for (int j = s; j <= t; j++) {
                if (calendar[j] == 0) {
                    numDays++;
                }
                calendar[j]++;
            }
        }
        pw.println(numDays);
        pw.close();
        br.close();
    }
}
