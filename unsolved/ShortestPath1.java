import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class ShortestPath1 {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); // number of nodes in the graph
        int m = io.getInt(); // number of edges
        int q = io.getInt(); /// number of queries
        int s = io.getInt(); // index of the starting node
        while (true) {
            if (n == 0 && m == 0 && q == 0 && s == 0) {
                break;
            }
            // initialising graph
            List<Vertex> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new Vertex(i));
            }
            // adding edges
            for (int i = 0; i < m; i++) {
                int u = io.getInt(); // node u
                int v = io.getInt(); // node v
                int w = io.getInt(); // weight of edge uv
                graph.get(u).edges.add(new Edge(u, v, w)); // unidirectional
            }
            // dijkstra
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            Set<Integer> solved = new HashSet<>();
            int[] shortestDistance = new int[n];
            for (int i = 0; i < n; i++) {
                shortestDistance[i] = 1001;
            }
            shortestDistance[s] = 0;
            pq.add(new Edge(s, s, 0));
            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                if (!solved.contains(edge.v)) {
                    solved.add(edge.v);
                    for (Edge outgoingEdge : graph.get(edge.v).edges) {
                        if (shortestDistance[outgoingEdge.u] + outgoingEdge.w < shortestDistance[outgoingEdge.v]) { // relaxation
                            shortestDistance[outgoingEdge.v] = shortestDistance[outgoingEdge.u] + outgoingEdge.w;
                            pq.add(outgoingEdge);
                        }
                    }
                }
            }
            // queries
            for (int i = 0; i < q; i++) {
                int query = io.getInt();
                if (shortestDistance[query] == 1001) {
                    io.println("Impossible");
                } else {
                    io.println(shortestDistance[query]);
                }
            }
            io.println();
            n = io.getInt();
            m = io.getInt();
            q = io.getInt();
            s = io.getInt();
        }
        io.close();
    }
}

class Vertex {
    int num;
    List<Edge> edges;

    public Vertex(int num) {
        this.num = num;
        this.edges = new ArrayList<>();
    }
}

class Edge implements Comparable<Edge> {
    public int u; // node u
    public int v; // node v
    public int w; // weight

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge another) {
        return this.w - another.w;
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
