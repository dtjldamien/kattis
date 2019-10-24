import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Ladice {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt(); // the number of items
        int L = io.getInt(); // the number of drawers
        UnionFind ufds = new UnionFind(L); // set of drawers
        for (int n = 0; n < N; n++) {
            int A = io.getInt() - 1; // index 0
            int B = io.getInt() - 1; // index 0
            ufds.unionSet(A, B);
            int predecessor = ufds.findSet(A);
            if (ufds.size[predecessor] > ufds.numItems[predecessor]) { // can store more items
                io.println("LADICA");
                ufds.numItems[predecessor]++; // add the item to the set
            } else { // unable to store more items
                io.println("SMECE");
            }
        }
        io.close();
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

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
            }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
