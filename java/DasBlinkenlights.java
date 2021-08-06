
// https://open.kattis.com/problems/dasblinkenlights
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DasBlinkenlights {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);
        int s = Integer.parseInt(input[2]);
        int lcm = getLCM(p, q);
        if (lcm <= s) {
            pw.println("yes");
        } else {
            pw.println("no");
        }
        br.close();
        pw.close();
    }

    public static int getLCM(int a, int b) {
        int gcd = getGCD(a, b);
        int lcm = (a * b) / gcd;
        return lcm;
    }

    public static int getGCD(int a, int b) {
        int gcd = 1;
        for (int i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
