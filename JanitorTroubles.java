import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class JanitorTroubles {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int d = Integer.parseInt(input[3]);
        double s = 1.0 * (a + b + c + d) / 2; // semiperimeter, search Bretscheider's formula
        double area = Math.sqrt((s - a) * (s - b) * (s - c) * (s - d));
        pw.println(area);
        pw.close();
        br.close();
    }
}