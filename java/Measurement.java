// https://open.kattis.com/problems/measurement
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Measurement {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int[] order = {1, 1000, 12, 3, 22, 10, 8, 3};
        String[] input = br.readLine().split(" ");
        double v = Double.parseDouble(input[0]);
        int idx1 = getIndex(input[1]);
        int idx2 = getIndex(input[3]);
        if (idx1 < idx2) {
            for (int i = idx1 + 1; i <= idx2; i++) {
                v /= order[i];
            }
        } else {
            for (int i = idx1; i > idx2; i--) {
                v *= order[i];
            }
        }
        pw.println(v);
        pw.close();
        br.close();
    }

    public static int getIndex(String unit) {
        if (unit.equals("thou") || unit.equals("th")) {
            return 0;
        } else if (unit.equals("inch") || unit.equals("in")) {
            return 1;
        } else if (unit.equals("foot") || unit.equals("ft")) {
            return 2;
        } else if (unit.equals("yard") || unit.equals("yd")) {
            return 3;
        } else if (unit.equals("chain") || unit.equals("ch")) {
            return 4;
        } else if (unit.equals("furlong") || unit.equals("fur")) {
            return 5;
        } else if (unit.equals("mile") || unit.equals("mi")) {
            return 6;
        } else { // league or lea
            return 7;
        }
    }
}
