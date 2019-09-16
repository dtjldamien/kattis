import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumKindOfProblem {
    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        for (int k = 1; k <= p; k++) {
            StringBuilder sb = new StringBuilder();
            String input = br.readLine();
            String[] data = input.split(" ");
            int dataNum = Integer.parseInt(data[0]); 
            int n = Integer.parseInt(data[1]);
            int sumPositive = (int) ((1.0 * n / 2) * (2 + (n - 1) * 1));
            int sumOdd = (int) (1.0 * n / 2 * (2 + (n - 1) * 2));
            int sumEven = (int) (1.0 * n / 2 * (4 + (n - 1) * 2));
            // APGP formula
            sb.append(dataNum);
            sb.append(" ");
            sb.append(sumPositive);
            sb.append(" ");
            sb.append(sumOdd);
            sb.append(" ");
            sb.append(sumEven);
            pw.println(sb.toString());
        }
        br.close();
        pw.close();
    }
}
