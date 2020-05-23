import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class HumanCannonball2 {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt(); // number of test cases
        for (int i = 0; i < N; i++) {
            double v0 = io.getDouble();
            double theta = io.getDouble();
            double x1 = io.getDouble();
            double h1 = io.getDouble();
            double h2 = io.getDouble();

            double t = x1 / v0 / Math.cos(Math.toRadians(theta));
            double y = v0 * t * Math.sin(Math.toRadians(theta)) - 0.5 * 9.81 * Math.pow(t, 2);

            if (y - h1 >= 1 && h2 - y >= 1) {
                io.println("Safe");
            } else {
                io.println("Not Safe");
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
