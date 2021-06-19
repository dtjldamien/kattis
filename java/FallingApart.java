package java;
// https://open.kattis.com/problems/fallingapart
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Collections;

public class FallingApart {
        public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(n, Collections.reverseOrder());
        String[] input = br.readLine().split(" ");
        for (String a : input) {
            pq.add(Integer.parseInt(a));
        }
        int alice = 0;
        int bob = 0;
        boolean isAliceTurn = true;
        while (!pq.isEmpty()) {
            if (isAliceTurn) {
                alice += pq.poll();
                isAliceTurn = false;
            } else {
                bob += pq.poll();
                isAliceTurn = true;
            }
        }
        pw.printf("%d %d\n", alice, bob);
        pw.close();
        br.close();
    }
}
