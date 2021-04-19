//https://open.kattis.com/problems/harshadnumbers
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HarshadNumbers {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        while(true) {
            int sumOfDigits = getSumOfDigits(n);
            if (n % sumOfDigits == 0) {
                pw.println(n);
                break;
            } else {
                n++;
            }
        }
        pw.close();
        br.close();
    }

    public static int getSumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + n  % 10;
            n = n / 10;
        }
        return sum;
    }
}