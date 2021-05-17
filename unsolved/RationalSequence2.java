// https://open.kattis.com/problems/rationalsequence2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Pair;
import java.util.List;
import java.util.Queue;

public class RationalSequence2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int P = Integer.parseInt(br.readLine());
        for (int i = 1; i <= P; i++) {
            String[] input = br.readLine().split(" ");
            int K = Integer.parseInt(input[0]);
            String[] F = input[1].split("/");
            Pair pair = new Pair(Integer.parseInt(n[0]), Integer.parseInt(n[1]));
            Queue<Pair> pq = new PriorityQueue<>();
            pq.add(pair);
            while (!pq.isEmpty()) {
                Pair e = pq.poll();
                if (e.p == 1 || e.q == 1) {

                }
            }
            int n = 0;
            pw.printf("%d %d", K, n);
        }
        double a = Double.parseDouble(br.readLine());
        pw.println(4 * Math.sqrt(a));
        pw.close();
        br.close();
    }
}

class Pair implements Comparable<Pair> {
    int p;
    int q;

    public Pair(int p, int q) {
        this.p = p;
        this.q = q;
    }

    @Override
    public int compareTo(Pair other) {
        int thisValue =  Math.min(this.p, this.q);
        int otherValue = Math.min(other.p, other.q);
        return thisValue - otherValue;
    }
}
