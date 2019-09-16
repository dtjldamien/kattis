import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExactlyElectrical {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] startPoint = br.readLine().split(" ");
        String[] endPoint = br.readLine().split(" ");
        int a = Integer.parseInt(startPoint[0]);
        int b = Integer.parseInt(startPoint[1]);
        int c = Integer.parseInt(endPoint[0]);
        int d = Integer.parseInt(endPoint[1]);
        int t = Integer.parseInt(br.readLine());
        int numUnitsNeeded = Math.abs(a - c) + Math.abs(b - d);
        if (t == numUnitsNeeded) {
            pw.print("Y");
        } else {
            if (t > numUnitsNeeded && (t - numUnitsNeeded) % 2 == 0) { // can move up and down or left and right to use up the charge
                pw.println("Y");
            } else {
                pw.print("N");
            }
        }
        br.close();
        pw.close();
    }
}