import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Planina {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int numPoints = (int) (Math.pow((Math.pow(2, n) + 1), 2));
        pw.println(numPoints);
        pw.close();
    }
}