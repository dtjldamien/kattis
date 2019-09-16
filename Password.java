import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Password {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numPasswords = Integer.parseInt(br.readLine());
        double[] probabilities = new double[numPasswords];
        String[] input;
        for (int i = 0; i < numPasswords; i++) {
            input = br.readLine().split(" ");
            probabilities[i] = Double.parseDouble(input[1]);
        }
        Arrays.sort(probabilities);
        double numTries = 0;
        for (int i = 1; i <= numPasswords; i++) {
            numTries += probabilities[numPasswords - i] * i;
        }
        pw.println(String.format("%.4f", numTries));
        pw.close();
        br.close();
    }
}