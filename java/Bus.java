import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Bus {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int initial = (int) Math.pow(2, k) - 1;
            pw.println(initial);
        }
        br.close();
        pw.close();
    }
}
