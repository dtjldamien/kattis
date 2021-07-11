// https://open.kattis.com/problems/forcedchoice
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ForcedChoice {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            String[] firstLine = br.readLine().split(" ");
            // int n = Integer.parseInt(firstLine[0]);
            int p = Integer.parseInt(firstLine[1]);
            int s = Integer.parseInt(firstLine[2]);

            String[] choices;
            int m;
            boolean isPrediction;
            for (int i = 0; i < s; i++) {
                isPrediction = false;
                choices = br.readLine().split(" ");
                m = Integer.parseInt(choices[0]);
                for (int j = 1; j <= m; j++) {
                    if (Integer.parseInt(choices[j]) == p) {
                        isPrediction = true;
                        break;
                    }
                }
                if (isPrediction) {
                    pw.println("KEEP");
                } else {
                    pw.println("REMOVE");
                }
            }
            pw.close();
            br.close();    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
