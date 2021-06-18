// https://open.kattis.com/problems/speeding
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Speeding {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int prevT = Integer.parseInt(input[0]);
        int prevD = Integer.parseInt(input[1]);
        int maxSpeed = 0;
        for (int i = 1; i < n; i++) {
            input = br.readLine().split(" ");
            int currT = Integer.parseInt(input[0]);
            int currD = Integer.parseInt(input[1]);
            int currSpeed = (currD - prevD) / (currT - prevT);
            if (currSpeed > maxSpeed) {
                maxSpeed = currSpeed;
            }
            prevT = currT;
            prevD = currD;
        }
        pw.println(maxSpeed);
        pw.close();
        br.close();
    }
}
