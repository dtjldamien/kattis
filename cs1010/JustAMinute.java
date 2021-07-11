
// https://open.kattis.com/problems/justaminute
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class JustAMinute {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int totalMinutes = 0;
        int totalSeconds = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            totalMinutes += Integer.parseInt(input[0]);
            totalSeconds += Integer.parseInt(input[1]);
        }
        double slMinute = (1.0 * totalSeconds) / (totalMinutes * 60);
        if (slMinute > 1) {
            pw.println(slMinute);
        } else {
            pw.println("measurement error");
        }
        pw.close();
        br.close();
    }
}
