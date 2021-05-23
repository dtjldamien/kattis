package java;
// https://open.kattis.com/problems/rationalsequence2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.PriorityQueue;

public class RationalSequence2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int P = Integer.parseInt(br.readLine());
        for (int i = 1; i <= P; i++) {
            String[] input = br.readLine().split(" ");
            int K = Integer.parseInt(input[0]);
            String[] F = input[1].split("/");
            Pair pair = new Pair(Integer.parseInt(F[0]), Integer.parseInt(F[1]));
            Queue<Pair> pq = new PriorityQueue<>();
            while (pair.p != 1 || pair.q != 1) {
                pq.add(pair);
                if (pair.p > pair.q) {
                    pair = new Pair (pair.p - pair.q, pair.q);
                } else  {
                    pair = new Pair (pair.p, pair.q - pair.p);
                }
            }
            int n = 1;
            while (!pq.isEmpty()) {
                pair = pq.poll();
                n *= 2; // traverse up one level from the left child
                if (pair.p > pair.q) {
                    n++; // up one level from the right child
                }
            }
            pw.printf("%d %d\n", K, n);
        }
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
