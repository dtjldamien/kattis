import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Statistics {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n;
        int caseNum = 1;
        int min;
        int max;
        int temp;
        int range;
        while (io.hasMoreTokens()) {
            n = io.getInt();
            min = io.getInt();
            max = min;
            for (int i = 1; i < n; i++) {
                temp = io.getInt();
                min = (int) Math.min(min, temp);
                max = (int) Math.max(max, temp);
            }
            range = max - min;
            io.println(String.format("Case %d: %d %d %d", caseNum, min, max, range));
            caseNum++;
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