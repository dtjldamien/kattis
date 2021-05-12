
// https://open.kattis.com/problems/skolavslutningen
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Skolavslutningen {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            String[] firstLine = br.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);
            int k = Integer.parseInt(firstLine[2]);
            UnionFind ufds = new UnionFind(k);
            String input;
            for (int i = 0; i < n; i++) {
                input = br.readLine();
                int firstSet = ufds.findSet(input.charAt(0) - 'A');
                for (int j = 1; j < m; j++) {
                    if (!ufds.isSameSet(firstSet, ufds.findSet(input.charAt(j) - 'A'))) {
                        ufds.unionSet(firstSet, input.charAt(j) - 'A');
                        k--;
                    }
                }
            }
            pw.println(k);
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UnionFind {
    public int[] p; // predecessor array
    public int[] rank;
    public int[] size; // array of storage size of the sets, start from 1 since all drawers can store one item
    public int[] numItems; // array of no of items in the sets

    public UnionFind(int N) {
        p = new int[N];
        rank = new int[N];
        size = new int[N];
        numItems = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            size[i] = 1;
        }
    }

    public int findSet(int i) {
        if (p[i] == i) {
            return i;
        } else {
            p[i] = findSet(p[i]);
            return p[i];
        }
    }

    public boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            int x = findSet(i), y = findSet(j); // x predecessor of i, y predecessor of j
            // rank is used to keep the tree short
            if (rank[x] > rank[y]) {
                p[y] = x;
                size[x] += size[y];
                numItems[x] += numItems[y];
            } else {
                p[x] = y;
                if (rank[x] == rank[y]) {
                    rank[y] = rank[y] + 1;
                }
                size[y] += size[x];
                numItems[y] += numItems[x];
            }
        }
    }
}

