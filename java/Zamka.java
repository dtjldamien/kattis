// https://open.kattis.com/problems/zamka
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Zamka {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int l = io.getInt();
        int d = io.getInt();
        int x = io.getInt();
        int n;
        int m;
        int sumOfDigits = 0;
        for (int i = l; i <= d; i++) {
            n = i;
            while (n != 0) {
                sumOfDigits += (n % 10);
                n /= 10;
            }
            if (sumOfDigits == x) {
                io.println(i);
                break;
            }
            sumOfDigits = 0;
        }
        sumOfDigits = 0;
        for (int i = d; i >= l; i--) {
            m = i;
            while (m != 0) {
                sumOfDigits += (m % 10);
                m /= 10;
            }
            if (sumOfDigits == x) {
                io.println(i);
                break;
            }
            sumOfDigits = 0;
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
