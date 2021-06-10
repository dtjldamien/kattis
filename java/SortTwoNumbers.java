package java;
// https://open.kattis.com/problems/sorttwonumbers
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SortTwoNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        Integer a = Integer.parseInt(input[0]);
        Integer b = Integer.parseInt(input[1]);
        if (a < b) {
            pw.printf("%d %d\n", a, b);
        } else {
            pw.printf("%d %d\n", b, a);
        }
        pw.close();
        br.close();
    }

}
