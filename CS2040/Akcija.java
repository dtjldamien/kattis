import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Akcija {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numBooks = Integer.parseInt(br.readLine());
        int[] prices = new int[numBooks];
        int lowestPrice = 0;
        for (int i = 0; i < numBooks; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(prices);
        for (int i = numBooks - 1; i > 1; i -= 3) {
            lowestPrice += prices[i] + prices[i - 1];
        }
        if (numBooks % 3 == 1) {
            lowestPrice += prices[0];
        } else if (numBooks % 3 == 2) {
            lowestPrice += prices[0] + prices[1];
        }
        pw.println(lowestPrice);
        pw.close();
        br.close();
    }
}