
// https://open.kattis.com/problems/firefly
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Firefly {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        // first is a stalagmite, rising from the floor
        // next is a stalacite, hanging from the ceiling
        int[] stalagmites = new int[h];
        int[] stalacites = new int[h];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                stalagmites[Integer.parseInt(br.readLine()) - 1]++;
            } else {
                stalacites[h - Integer.parseInt(br.readLine())]++;
            }
        }

        // calculate prefix sums
        int sum = 0;
        for (int i = h - 1; i >= 0; i--) {
            sum += stalagmites[i];
            stalagmites[i] = sum;
        }

        sum = 0;
        for (int i = 0; i < h; i++) {
            sum += stalacites[i];
            stalacites[i] = sum;
        }

        int minObstaclesDestroyed = Integer.MAX_VALUE;
        int numLevels = 0;
        for (int i = 0; i < h; i++) {
            if (stalagmites[i] + stalacites[i] < minObstaclesDestroyed) {
                minObstaclesDestroyed = stalagmites[i] + stalacites[i];
                numLevels = 1;
            } else if (stalagmites[i] + stalacites[i] == minObstaclesDestroyed) {
                numLevels++;
            }
        }

        pw.printf("%d %d\n", minObstaclesDestroyed, numLevels);
        pw.close();
        br.close();
    }
}
