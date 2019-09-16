import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GrassSeed {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        double seedCost = Double.parseDouble(br.readLine());
        int numLawns = Integer.parseInt(br.readLine());
        double area = 0;
        for (int i = 0; i < numLawns; i++) {
            String[] dimensions = br.readLine().split(" ");
            area += Double.parseDouble(dimensions[0]) * Double.parseDouble(dimensions[1]);
        }
        pw.println(String.format("%.6f", area * seedCost));
        pw.close();
        br.close();
    }
}