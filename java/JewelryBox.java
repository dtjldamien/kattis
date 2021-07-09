// https://open.kattis.com/problems/jewelrybox
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class JewelryBox {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            double h1 = (y + x - Math.sqrt(y * y - x * y + x * x)) / 6.0;
            double h2 = (y + x + Math.sqrt(y * y - x * y + x * x)) / 6.0;
            if (h1 < 0) {
                pw.println(2 * (y - 2 * h2) * (x - 2 * h2));
            } else if (h2 < 0) {
                pw.println(h1 * (y - 2 * h1) * (x - 2 * h1));
            } else {
                pw.println(Math.max(h1 * (y - 2 * h1) * (x - 2 * h1), 2 * (y - 2 * h2) * (x - 2 * h2)));
            }
        }
        pw.close();
        br.close();
    }
}
