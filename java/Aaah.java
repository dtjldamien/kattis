
// https://open.kattis.com/problems/aaah
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Aaah {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            String firstLine = br.readLine();
            String secondLine = br.readLine();
            if (firstLine.length() >= secondLine.length()) {
                pw.println("go");
            } else {
                pw.println("no");
            }
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
