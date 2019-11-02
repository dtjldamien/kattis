import java.util.ArrayList;
import java.util.List;
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
import java.awt.Point;

public class MillionaireMadness {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int m = io.getInt(); // length of the vault
        int n = io.getInt(); // width of the vault
        int[][] vault = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vault[i][j] = io.getInt(); // initialising the vault
            }
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        List<Edge> path = new ArrayList<>();
        edges.add(new Edge(new Point(0, 0), 0));

        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            path.add(edge);
            Point source = edge.destination;
            if (source.x == m - 1 && source.y == n - 1) { // southeast corner
                break;
            }
            if (!visited[source.x][source.y]) {
                visited[source.x][source.y] = true;
                if (source.x < m - 1) { // add right
                    Point destination = new Point(source.x + 1, source.y);
                    if (vault[source.x + 1][source.y] - vault[source.x][source.y] < 0) {
                        edges.add(new Edge(destination, 0));
                    } else {
                        edges.add(new Edge(destination, vault[source.x + 1][source.y] - vault[source.x][source.y]));
                    }
                }
                if (source.x > 0) { // add left
                    Point destination = new Point(source.x - 1, source.y);
                    if (vault[source.x - 1][source.y] - vault[source.x][source.y] < 0) {
                        edges.add(new Edge(destination, 0));
                    } else {
                        edges.add(new Edge(destination, vault[source.x - 1][source.y] - vault[source.x][source.y]));
                    }
                }
                if (source.y < n - 1) { // add down
                    Point destination = new Point(source.x, source.y + 1);
                    if (vault[source.x][source.y + 1] - vault[source.x][source.y] < 0) {
                        edges.add(new Edge(destination, 0));
                    } else {
                        edges.add(new Edge(destination, vault[source.x][source.y + 1] - vault[source.x][source.y]));
                    }
                }
                if (source.y > 0) { // add up
                    Point destination = new Point(source.x, source.y - 1);
                    if (vault[source.x][source.y - 1] - vault[source.x][source.y] < 0) {
                        edges.add(new Edge(destination, 0));
                    } else {
                        edges.add(new Edge(destination, vault[source.x][source.y - 1] - vault[source.x][source.y]));
                    }
                }
            }
        }

        int maxLadderLength = 0;
        for (Edge edge : path) {
            if (edge.distance > maxLadderLength) {
                maxLadderLength = edge.distance;
            }
        }

        io.println(maxLadderLength);
        io.close();
    }
}

class Edge implements Comparable<Edge> {
    public Point destination;
    public int distance;

    public Edge(Point destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge another) {
        return this.distance - another.distance;
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
