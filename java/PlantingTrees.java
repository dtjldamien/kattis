
// https://open.kattis.com/problems/plantingtrees
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class PlantingTrees {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        ArrayList<Integer> trees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            trees.add(Integer.parseInt(input[i]));
        }
        Collections.sort(trees);
        int numDays = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (trees.get(i) + n - i > numDays) {
                numDays = trees.get(i) - i + n;
            }
        }
        numDays++;
        pw.println(numDays);
        pw.close();
        br.close();
    }
}