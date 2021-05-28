// https://open.kattis.com/problems/kleptography
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Kleptography {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String keyword = br.readLine();
        String ciphertext = br.readLine();
        char[] plaintext = new char[m];
        for (int i = 1; i <= n; i++)  {
            plaintext[m - i] = keyword.charAt(n - i);
        }
        for (int i = m - 1; i > n - 1; i--) {
            plaintext[i - n]  = (char) ('a' + (26 + ciphertext.charAt(i) - plaintext[i]) % 26);
        }
        pw.println(String.valueOf(plaintext));
        pw.close();
        br.close();
    }
}
