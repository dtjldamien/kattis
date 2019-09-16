import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HeartRate {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int b = Integer.parseInt(input[0]);
            double p = Double.parseDouble(input[1]);
            double bpm = (60.0 * b) / p;
            double minABPM = (60.0) / (1.0 * p / (b - 1));
            double maxABPM = (60.0) / (1.0 * p / (b + 1));
            pw.println(String.format("%.4f %.4f %.4f", minABPM, bpm, maxABPM));
        }
        pw.close();
        br.close();
    }
}