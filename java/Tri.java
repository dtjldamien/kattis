
// https://open.kattis.com/problems/tri
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Tri {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        while (true) {
            if (a + b == c) {
                pw.printf("%d+%d=%d\n", a, b, c);
                break;
            } else if (a - b == c) {
                pw.printf("%d-%d=%d\n", a, b, c);
                break;       
            } else if (a * b == c) {
                pw.printf("%d*%d=%d\n", a, b, c);
                break;       
            } else if (a / b == c) {
                pw.printf("%d/%d=%d\n", a, b, c);
                break;       
            } else if (a + b == c) {
                pw.printf("%d+%d=%d\n", a, b, c);
                break;
            } else if (a - b == c) {
                pw.printf("%d-%d=%d\n", a, b, c);
                break;       
            } else if (a * b == c) {
                pw.printf("%d*%d=%d\n", a, b, c);
                break;       
            } else if (a / b == c) {
                pw.printf("%d/%d=%d\n", a, b, c);
                break;       
            } else if (a == b + c) {
                pw.printf("%d=%d+%d\n", a, b, c);
                break;
            } else if (a == b - c) {
                pw.printf("%d=%d-%d\n", a, b, c);
                break;
            } else if (a == b * c) {
                pw.printf("%d=%d*%d\n", a, b, c);
                break;
            } else if (a == b / c) {
                pw.printf("%d=%d/%d\n", a, b, c);
                break;
            }
        }
        pw.close();
        br.close();
    }
}