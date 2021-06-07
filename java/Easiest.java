// https://open.kattis.com/problems/easiest
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Easiest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        while (N != 0) {
            int sumOfN = getSumOfDigits(N);
            for (int m = 11; true; m++) {
                int test = N * m;
                if (getSumOfDigits(test) == sumOfN) {
                    pw.println(m);
                    break;
                }
            }
            N = Integer.parseInt(br.readLine());
        }
        pw.close();
        br.close();
    }

    public static int getSumOfDigits(int x) {
        int sumOfDigits = 0;
        while (x > 0) {
            sumOfDigits += x % 10;
            x /= 10;
        }
        return sumOfDigits;
    }
}
