package java;

// https://open.kattis.com/problems/watchdog
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Watchdog {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] roof = br.readLine().split(" ");
            int s = Integer.parseInt(roof[0]);
            int h = Integer.parseInt(roof[1]);
            List<Hatch> hatches = new ArrayList<>();
            for (int j = 0; j < h; j++) {
                String[] coordinates = br.readLine().split(" ");
                hatches.add(new Hatch(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
            }
            boolean isPossible = true;
            loop: for (int row = 1; row < s - 1; row++) {
                for (int col = 1; col < s - 1; col++) {
                    double max = Math.min(Math.min(row, s - row), Math.min(col, s - col));
                    isPossible = true;
                    for (Hatch hatch : hatches) {
                        if ((hatch.x == row && hatch.y == col)
                                || max < Math.sqrt(Math.pow((hatch.x - row), 2) + Math.pow((hatch.y - col), 2))) {
                            isPossible = false;
                        }
                    }
                    if (isPossible) {
                        pw.printf("%d %d\n", row, col);
                        break loop;
                    }
                }
            }
            if (!isPossible) {
                pw.println("poodle");
            }
        }
        pw.close();
        br.close();
    }
}

class Hatch {
    int x;
    int y;

    public Hatch(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
