import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class GrandpaBernie {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<String> countries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = io.getWord();
            int y = io.getInt();
            if (map.containsKey(s)) {
                ArrayList<Integer> list = map.get(s);
                list.add(y);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(y);
                map.put(s, list);
                countries.add(s);
            }
        }
        for (String country : countries) {
            ArrayList<Integer> list = map.get(country);
            Collections.sort(list);
        }
        int q = io.getInt();
        for (int i = 0; i < q; i++) {
            String s = io.getWord();
            ArrayList<Integer> list = map.get(s);
            int k = io.getInt();
            io.println(list.get(k - 1));
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