import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.Arrays;

public class Baloni {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = io.getInt();
        }
        int arrowCount = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == 0) {
                continue;
            } else if (i == n - 1) {
                arr[i] = 0;
                // just pop
            } else {
                int index = i + 1;
                int height = arr[i] - 1;
                arr[i] = 0; // popped
                while (index < n && height > 0) {
                    if (arr[index] == height) {
                        arr[index] = 0; // popped
                        height--;
                    }
                    index++;
                }
            }
            arrowCount++;
        }
        io.print(arrowCount);
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