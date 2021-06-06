
// https://open.kattis.com/problems/prsteni
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Prsteni {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String[] radii = br.readLine().split(" ");
        int firstRadius = Integer.parseInt(radii[0]);
        for (int i = 1; i < N; i++) {
            int currRadius = Integer.parseInt(radii[i]);
            // initially set to gcd
            int gcd = 1;
            for (int j = 2; j <= firstRadius && j <= currRadius; j++) {
                if (firstRadius % j == 0 && currRadius % j == 0) {
                    gcd = j;
                }
            }
            pw.printf("%d/%d\n", firstRadius / gcd, currRadius / gcd);
        }
        pw.close();
        br.close();
    }
}
