
// https://open.kattis.com/problems/estimatingtheareaofacircle
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class EstimatingTheAreaOfACircle {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        double r; // true radius
        double m; // total number of marked points
        double c; // number of marked points that fall in the circle
        double trueArea;
        double squareArea;
        double estimate;
        while (true) {
            r = io.getDouble();
            m = io.getDouble();
            c = io.getDouble();
            if (r == 0 && m == 0 && c == 0) {
                break;
            } else {
                trueArea = Math.PI * r * r;
                squareArea = 4 * r * r; // length x breadth = 2r * 2r
                estimate = squareArea * c / m;
                io.printf("%s %s\n", trueArea, estimate);
            }
        }
        io.close();
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