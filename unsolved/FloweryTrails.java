import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class FloweryTrails {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int p = io.getInt(); // number of points of interest
        int t = io.getInt(); // number of trails

        Point[] park = new Point[p]; // adjacency list
        for (int i = 0; i < p; i++) {
            park[i] = new Point(i);
        }

        for (int i = 0; i < t; i++) {
            int p1 = io.getInt();
            int p2 = io.getInt();
            int l = io.getInt();
            park[p1].trails.add(new Trail(p1, p2, l));
            park[p2].trails.add(new Trail(p2, p1, l));
        }

        int[] shortestDistance = new int[p];
        Set<Integer> solved = new HashSet<>();

        PriorityQueue<Trail> pq = new PriorityQueue<>();
        Trail source = new Trail(0, 0, 0);
        shortestDistance[0] = 0;
        pq.add(source);
        for (int i = 1; i < p; i++) {
            Trail path = new Trail(0, i, 1001);
            shortestDistance[i] = 1001;
            pq.add(path);
        }

        while (!pq.isEmpty()) {
            Trail path = pq.poll();
            if (!solved.contains(path.destination)) {
                solved.add(path.destination);
                Point point = park[path.destination];
                for (Trail trail : point.trails) {
                    // relaxation of all outgoing edges
                    if (shortestDistance[trail.source] + trail.distance < shortestDistance[trail.destination]) {
                        shortestDistance[trail.destination] = shortestDistance[trail.source] + trail.distance;
                        Trail outgoingPath = new Trail(trail.source, trail.destination, shortestDistance[trail.destination]);
                        pq.add(outgoingPath);
                    }
                }
            }
            if (solved.contains(p - 1)) {
                break;
            }
        }
        
        int extentOfFlowers = 2 * calculateExtent(park, shortestDistance, p - 1);
        io.println(extentOfFlowers);
        io.close();
    }

    public static int calculateExtent(Point[] park, int[] shortestDistance,int destination) {
        if (destination == 0) {
            return 0;
        } else {
            Point point = park[destination];
            int extent = 0;
            Set<Integer> predecessors = new HashSet<>();
            for (Trail trail : point.trails) {
                if (shortestDistance[destination] == shortestDistance[trail.destination] + trail.distance) {
                    extent += trail.distance;
                    predecessors.add(trail.destination);
                }
            }
            for (Integer predecessor : predecessors) {
                extent += calculateExtent(park, shortestDistance, predecessor);
            }
            return extent;
        }
    }
}

class Point {

    public int pointNumber;
    public List<Trail> trails;

    public Point(int pointNumber) {
        this.pointNumber = pointNumber;
        this.trails = new ArrayList<>();
    }
}

class Trail implements Comparable<Trail>{

    public int source; // point of interest
    public int destination; // point of interest
    public int distance; // length of trail

    public Trail(int p1, int p2, int l) {
        this.source = p1;
        this.destination = p2;
        this.distance = l;
    }

    @Override
    public int compareTo(Trail another) {
        if (this.distance == another.distance) {
            if (this.source == another.source) {
                return this.destination - another.destination;
            } else {
                return this.source - another.source;
            }
        } else {
            return this.distance - another.distance;
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
