// https://open.kattis.com/problems/reverserot
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.StringBuilder;

public class ReverseRot {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        while (n != 0) {
            StringBuilder sb = new StringBuilder(input[1]);
            sb.reverse();
            for (int i = 0; i < sb.length(); i++) {
                sb.setCharAt(i, getShiftedChar(sb.charAt(i), n));
            }
            pw.println(sb.toString());
            input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
        }
        pw.close();
        br.close();
    }

    public static char getShiftedChar(char x, int n) {
        while (n > 0) {
            if (x >= 'A' && x < 'Z') {
                x = (char) ((int) (x + 1));
            } else if (x == 'Z') {
                x = '_';
            } else if (x == '_') {
                x = '.';
            } else if (x == '.') {
                x = 'A';
            }
            n--;
        }
        return x;
    }
}
