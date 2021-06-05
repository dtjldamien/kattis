// https://open.kattis.com/problems/greedypolygons
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GreedyPolygons {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numTestCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < numTestCase; i++) {
            String[] testCase = br.readLine().split(" ");
            int n = Integer.parseInt(testCase[0]); // number of initial sides
            int l = Integer.parseInt(testCase[1]); // initial side length
            int d = Integer.parseInt(testCase[2]); // expansion distance
            int g = Integer.parseInt(testCase[3]); // number of land grabs
            double polygonArea =  0.25 * n * l * l / Math.tan(Math.PI / n);
            double rectangleArea = n * l * d * g;
            double circleArea = ((180 - (n - 2) * 180.0 / n) / 360) * (Math.PI * Math.pow(d * g, 2) * n);
            double totalArea = polygonArea + rectangleArea + circleArea;
            pw.println(totalArea);
        }
        pw.close();
        br.close();
    }    
}
