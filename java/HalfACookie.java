package java;

// https://open.kattis.com/problems/halfacookie
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class HalfACookie {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio(System.in, System.out);
        while (io.hasMoreTokens()) {
            double r = io.getDouble();
            double x = io.getDouble();
            double y = io.getDouble();
            double distFromOrigin = Math.sqrt(x * x + y * y);
            if (distFromOrigin >= r) {
                io.println("miss");
            } else {
                double circleArea = Math.PI * r * r;
                double height = r - distFromOrigin;
                double struckArea = r * r * Math.acos((r - height)/ r) - (r - height) * Math.sqrt(2 * r * height - height * height);
                double remainingArea = circleArea - struckArea;
                if (struckArea > remainingArea) {
                    io.printf("%f %f\n", struckArea, remainingArea);
                } else {
                    io.printf("%f %f\n", remainingArea, struckArea);
                }
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
