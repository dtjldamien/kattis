// https://open.kattis.com/problems/jumbojavelin
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class JumboJavelin {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            int n = Integer.parseInt(br.readLine());
            int currLength = Integer.parseInt(br.readLine());
            int newRod = 0;
            for (int i = 1; i < n; i++) {
                newRod = Integer.parseInt(br.readLine());
                currLength = currLength + newRod - 1;
            }
            pw.println(currLength);
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}