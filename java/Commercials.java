// https://open.kattis.com/problems/commercials
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Commercials {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int p = Integer.parseInt(firstLine[1]);
        // largest sum contiguous subarray
        String[] secondLine = br.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        for (int i = 0; i < n; i++) {
            currMax += Integer.parseInt(secondLine[i]) - p;
            if (max < currMax) {
                max = currMax;
            }
            if (currMax < 0) {
                currMax = 0;
            }
        }
        pw.println(max);
        pw.close();
        br.close();
    }
}