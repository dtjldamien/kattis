import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ShatteredCake {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int width = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int area = 0;
        for (int i = 0; i < n; i++) {
            String[] dimensions = br.readLine().split(" "); 
            area += Integer.parseInt(dimensions[0]) * Integer.parseInt(dimensions[1]);
        }
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(area / width);
        br.close();
        pw.close();
    }
}