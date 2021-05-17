// https://open.kattis.com/problems/rijeci
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Rijeci {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            int K = Integer.parseInt(br.readLine());
            int countA = 1;
            int countB = 0;
            int temp = 0;
            for (int i = 0; i < K; i++) {
                temp = countB;

                // letters A get transformed to B
                countB = countA;

                // letters B get transformed to BA 
                countA = temp;
                countB += temp;
            }
            pw.printf("%d %d", countA, countB);
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
