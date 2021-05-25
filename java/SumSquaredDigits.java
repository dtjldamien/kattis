package java;

// https://open.kattis.com/problems/sumsquareddigits
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SumSquaredDigits {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            String[] input = br.readLine().split(" ");
            int K = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);
            int sum = 0;
            while (n > 0) {
                int remainder = n % b;
                sum += remainder * remainder;
                n = (n - remainder) / b;
            }
            pw.printf("%d %d\n", K, sum);
        }
        pw.close();
        br.close();
    }
}
