import java.util.Hashtable;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class VirtualFriends {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); // number of test cases to follow
        for (int i = 0; i < n; i++) {
            int F = io.getInt(); // number of friendships formed
            UnionFind ufds = new UnionFind(100000);
            Hashtable<String, Integer> table = new Hashtable<>(); // hash names to integer
            int counter = 0; // keep track of the number of unique names
            for (int j = 0; j < F; j++) {
                String nameA = io.getWord();
                String nameB = io.getWord();
                int indexA = 0;
                int indexB = 0;
                if (table.containsKey(nameA)) {
                    indexA = table.get(nameA);
                } else {
                    indexA = counter;
                    table.put(nameA, indexA);
                    counter++;
                }
                if (table.containsKey(nameB)) {
                    indexB = table.get(nameB);
                } else {
                    indexB = counter;
                    table.put(nameB, indexB);
                    counter++;
                }
                ufds.unionSet(indexA, indexB);
                int parentSet = ufds.findSet(indexA);
                io.println(ufds.size[parentSet]);
            }
        }
        io.close();
    }
}

class UnionFind {
    public int[] p;
    public int[] rank;
    public int[] size; // track the number of people in the social network (friends of friends)

    public UnionFind(int N) {
        p = new int[N];
        rank = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            rank[i] = 0;
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
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank[x] > rank[y]) {
                p[y] = x;
                size[x] += size[y];
            } else {
                p[x] = y;
                size[y] += size[x];
                if (rank[x] == rank[y]) {
                    rank[y] = rank[y] + 1;
                }
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
