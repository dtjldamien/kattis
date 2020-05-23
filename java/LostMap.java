import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;;

public class LostMap {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); // number of villages
        int[][] adjMtx = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMtx[i][j] = io.getInt();
            }
        }
        ArrayList<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edgeList.add(new Edge(i + 1, j + 1, adjMtx[i][j])); // index 1 based
            }
        }
        // sort by edge weight O(ElogE)
        Collections.sort(edgeList);
        ArrayList<Edge> mst = new ArrayList<>();
        UnionFind ufds = new UnionFind(n + 1); // index 1 based
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (!ufds.isSameSet(edge.u, edge.v)) { // if not cycle
                ufds.unionSet(edge.u, edge.v); // link these two vertices
                mst.add(edge);
            }
        }
        for (Edge edge : mst) {
            StringBuilder sb = new StringBuilder();
            sb.append(edge.u);
            sb.append(" ");
            sb.append(edge.v);
            io.println(sb.toString());
        }
        io.close();
    }
}

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int distance;

    public Edge(int u, int v, int distance) {
        this.u = u;
        this.v = v;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge another) {
        return this.distance - another.distance;
    }
}

// Union-Find Disjoint Sets Library, using both path compression and union by
// rank heuristics
class UnionFind {
    public ArrayList<Integer> p, rank, setSize;
    public int numSets;

    public UnionFind(int N) {
        p = new ArrayList<Integer>(N);
        rank = new ArrayList<Integer>(N);
        setSize = new ArrayList<Integer>(N);
        numSets = N;
        for (int i = 0; i < N; i++) {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i) {
        if (p.get(i) == i) {
            return i;
        } else {
            int ret = findSet(p.get(i));
            p.set(i, ret);
            return ret;
        }
    }

    public Boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            numSets--;
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank.get(x) > rank.get(y)) {
                p.set(y, x);
                setSize.set(x, setSize.get(x) + setSize.get(y));
            } else {
                p.set(x, y);
                setSize.set(y, setSize.get(y) + setSize.get(x));
                if (rank.get(x) == rank.get(y))
                    rank.set(y, rank.get(y) + 1);
            }
        }
    }

    public int numDisjointSets() {
        return numSets;
    }

    public int sizeOfSet(int i) {
        return setSize.get(findSet(i));
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
