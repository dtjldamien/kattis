import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

public class Conformity {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); // number of frosh
        HashMap<ArrayList<Integer>, Integer> combiMap = new HashMap<>(); // list -> mods, integer -> number of students with same combi
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> mods = new ArrayList<>();
            for (int j = 0; j < 5; j++) {   
                mods.add(io.getInt());
            }
            Collections.sort(mods);
            if (combiMap.containsKey(mods)) {
                int newValue = combiMap.get(mods) + 1;
                combiMap.replace(mods, newValue); // increase the num students taking that exact combi by 1
            } else {
                combiMap.put(mods, 1);
            }
        }
        if (combiMap.size() == n) { // all taking diff combis, therefore all frosh would win
            io.print(n);
        } else {
            Collection<Integer> values = combiMap.values();
            int maxValue = 1;
            for (int value : values) {
                if (value > maxValue) {
                    maxValue = value;
                }
            }
            int numWinners = 0;
            for (int value : values) {
                if (value == maxValue) {
                    numWinners += value; // add the number of winners
                }
            }
            io.print(numWinners);
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