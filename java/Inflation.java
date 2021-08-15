
// https://open.kattis.com/problems/inflation
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Inflation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        List<Integer> canisters = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            canisters.add(Integer.parseInt(input[i]));
        }
        Collections.sort(canisters);
        double minCapacity = 1;
        boolean isImpossible = false;
        for (int i = 0; i < n; i++) {
            if (canisters.get(i) > i + 1) {
                isImpossible = true;
                break;
            } else {
                double currCapacity = 1.0 * canisters.get(i) / (i + 1);
                minCapacity = Math.min(minCapacity, currCapacity);
            }
        }
        if (isImpossible) {
            pw.println("impossible");
        } else {
            pw.println(minCapacity);
        }
        pw.close();
        br.close();
    }
}
