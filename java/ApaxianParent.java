
// https://open.kattis.com/problems/apaxianparent
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ApaxianParent {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            String[] input = br.readLine().split(" ");
            if (input[0].charAt(input[0].length() - 1) == 'e') {
                pw.print(input[0]);
                pw.print('x');
                pw.println(input[1]);
            } else if (input[0].charAt(input[0].length() - 1) == 'a'
                    || input[0].charAt(input[0].length() - 1) == 'i'
                    || input[0].charAt(input[0].length() - 1) == 'o'
                    || input[0].charAt(input[0].length() - 1) == 'u') {
                pw.print(input[0].substring(0, input[0].length() - 1));
                pw.print("ex");
                pw.println(input[1]);
            } else if (input[0].endsWith("ex")) {
                pw.print(input[0]);
                pw.println(input[1]);
            } else {
                pw.print(input[0]);
                pw.print("ex");
                pw.println(input[1]);
            }
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
