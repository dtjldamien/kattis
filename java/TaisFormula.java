package java;
// https://open.kattis.com/problems/taisformula
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TaisFormula {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        int[] timings = new int[N];
        double[] values = new double[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            timings[i] = Integer.parseInt(input[0]);
            values[i] = Double.parseDouble(input[1]);
        }
        double totalArea = 0;
        for (int i = 0; i < N - 1; i++) {
            totalArea += ((values[i] + values[i + 1]) / 2) * ((timings[i + 1] - timings[i]) / 1000.0);
        }
        pw.println(totalArea);
        pw.close();
        br.close();
    }
}
