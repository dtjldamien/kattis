// https://open.kattis.com/problems/heimavinna
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Heimavinna {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(";");
        int numProblems = 0;
        for (int i = 0; i < input.length; i++) {
            String[] row = input[i].split("-");
            if (row.length == 1) {
                numProblems++;
            } else {
                numProblems = numProblems + Integer.parseInt(row[1]) - Integer.parseInt(row[0]) + 1;
            }
        }
        pw.println(numProblems);
        pw.close();
        br.close();
    }    
}
