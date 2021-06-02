// https://open.kattis.com/problems/fiftyshades
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FiftyShades {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine().toLowerCase();
            if (input.contains("pink") || input.contains("rose")) {
                count++;
            }
        }
        if (count == 0) {
            pw.println("I must watch Star Wars with my daughter");
        } else {
            pw.println(count);
        }
        pw.close();
        br.close();
    }
}
