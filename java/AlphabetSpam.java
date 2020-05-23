import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class AlphabetSpam {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        char[] input = io.getWord().toCharArray();
        int numWhitespace = 0;
        int numLowercase = 0;
        int numUppercase = 0;
        int numSymbols = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 95) {
                numWhitespace++;
            } else if (input[i] >= 97 && input[i] <= 122) {
                numLowercase++;
            } else if (input[i] >= 65 && input[i] <= 90) {
                numUppercase++;
            } else {
                numSymbols++;
            }
        }
        io.println(1.0 * numWhitespace / input.length);
        io.println(1.0 * numLowercase / input.length);
        io.println(1.0 * numUppercase / input.length);
        io.println(1.0 * numSymbols / input.length);
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
