import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class APrizeNoOneCanWin {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        String[] priceString = br.readLine().split(" ");
        int[] priceInt = new int[n];
        for (int i = 0; i < n; i++) {
            priceInt[i] = Integer.parseInt(priceString[i]);
        }
        Arrays.sort(priceInt);
        int numItems = 0;
        if (n > 1) {
            for (numItems = 1; numItems < n; numItems++) {
                if (priceInt[numItems - 1] + priceInt[numItems] > x) {
                    break;
                }
            }
        } else {
            numItems = 1;
        }
        pw.print(numItems);
        pw.close();
        br.close();
    }
}