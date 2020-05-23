import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ArticNetwork {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); // number of test cases
        for (int i = 0; i < n; i++) {
            int s = io.getInt(); // number of satellite channels
            int p = io.getInt(); // number of outposts
            List<Outpost> outposts = new ArrayList<>();
            for (int j = 0; j < p; j++) { // O(V);
                outposts.add(new Outpost(io.getInt(), io.getInt()));
            }

            List<CommunicationPath> paths = new ArrayList<>();
            for (int k = 0; k < p - 1; k++) {
                for (int l = k + 1; l < p; l++) {
                    Outpost o1 = outposts.get(k);
                    Outpost o2 = outposts.get(l);
                    double d = calculateD(o1, o2);
                    paths.add(new CommunicationPath(k, l, d));
                }
            }
            Collections.sort(paths); // O(Elog(E));

            List<CommunicationPath> mst = new ArrayList<>();
            UnionFind ufds = new UnionFind(p);
            for (int m = 0; m < paths.size(); m++) {
                CommunicationPath path = paths.get(m);
                if (!ufds.isSameSet(path.u, path.v)) {
                    ufds.unionSet(path.u, path.v);
                    mst.add(path);
                }
            }
            Collections.sort(mst); // O(Elog(E));

            int index = mst.size() - s; // outpost with highest d that does not have a satellite
            double d = mst.get(index).d;
            String output = String.format("%.2f", d);
            io.println(output);
        }
        io.close();
    }

    public static double calculateD(Outpost o1, Outpost o2) {
        return Math.sqrt(Math.pow(o1.x - o2.x, 2) + Math.pow(o1.y - o2.y, 2));
    }
}

class Outpost {
    public int x;
    public int y;

    public Outpost(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class CommunicationPath implements Comparable<CommunicationPath> {
    public int u;
    public int v;
    public double d;

    public CommunicationPath(int u, int v, double d) {
        this.u = u;
        this.v = v;
        this.d = d;
    }

    @Override
    public int compareTo(CommunicationPath another) {
        if (this.d == another.d) {
            if (this.u == another.u) {
                return this.v - another.v;
            } else {
                return this.u - another.u;
            }
        } else {
            if (this.d < another.d) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

class UnionFind {
    public ArrayList<Integer> p;
    public ArrayList<Integer> rank;
    public ArrayList<Integer> setSize;
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
