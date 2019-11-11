import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class HumanCanonball {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        double[] start = new double[2];
        start[0] = io.getDouble();
        start[1] = io.getDouble();
        double[] end = new double[2];
        end[0] = io.getDouble();
        end[1] = io.getDouble();
        int n = io.getInt(); // number of cannons
        double[][] points = new double[n + 2][2]; // stores all the points
        points[0][0] = start[0]; // put start as the first row
        points[0][1] = start[1]; 
        points[n + 1][0] = end[0]; // put end as the last row
        points[n + 1][1] = end[1]; // put end as the last row
        for (int i = 1; i < n + 1; i++) {
            points[i][0] = io.getDouble();
            points[i][1] = io.getDouble();
        }   
        double timeTakenToRun = distance(start[0], start[1], end[0], end[1]) / 5.0;
        double infinity = timeTakenToRun + 1; // cannot take longer than just running
        double[][] adjMtx = new double[n + 2][n + 2]; // new adjacency matrix
        // initialise the matrix to run floyd warshall's algorithm
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (i == j) {
                    adjMtx[i][j] = 0;
                } else {
                    adjMtx[i][j] = infinity;
                }
            }
        }
        // time taken to run from start to every other point
        for (int i = 1; i < n + 2; i++) {
            adjMtx[0][i] = distance(start[0], start[1], points[i][0], points[i][1]) / 5.0;
        }

        // compares time taken to run from a cannon
        // and time taken to use the cannon then running to the point
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 2; j++) {
                adjMtx[i][j] = Math.min(2 + Math.abs(((distance(points[i][0], points[i][1], points[j][0], points[j][1])) - 50) / 5.0), distance(points[i][0], points[i][1], points[j][0], points[j][1]) / 5.0);
            }
        }

        // floyds warshall algorithm (transitive closure)
        for (int k = 0; k < n + 2; k++) {
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    adjMtx[i][j] = Math.min(adjMtx[i][j], adjMtx[i][k] + adjMtx[k][j]);
                }
            }
        }
        io.println(adjMtx[0][n + 1]);
        io.close();
    }

    public static double distance(double aX, double aY, double bX, double bY) {
        return Math.sqrt(Math.pow(aX - bX, 2) + Math.pow(aY - bY, 2));
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
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
