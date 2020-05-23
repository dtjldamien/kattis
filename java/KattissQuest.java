import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.TreeMap;

public class KattissQuest {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt(); // number of commands
        TreeMap<Integer, PriorityQueue<Long>> quests = new TreeMap<>(); // tree of all quests sorted by energy
        for (int i = 0; i < N; i++) {
            String command = io.getWord();
            if (command.equals("add")) {
                int E = io.getInt(); // energy consumption of the quest
                long G = io.getLong(); // gold reward of the quest
                PriorityQueue<Long> goldValues;
                if (quests.containsKey(E)) { // quest with the same energy
                    goldValues = quests.remove(E); // get the previous priority queue
                    goldValues.add(G);
                    quests.put(E, goldValues);    
                } else { // no other quest with same energy cost
                    goldValues = new PriorityQueue<Long>(new Comparator<Long>() {
                        public int compare(Long o1, Long o2) { // max pq
                            if (o1 > o2) {
                                return -1;
                            } else {
                                return 1;
                            }
                        }
                    });
                    goldValues.add(G);
                    quests.put(E, goldValues);    
                }
            } else { // command.equals("query")
                int X = io.getInt(); // amount of energy kattis cat has
                long totalGoldEarned = 0; // gold earned with energy X
                while (X > 0) {
                    if (quests.containsKey(X)) {
                        PriorityQueue<Long> goldValues = quests.remove(X);
                        totalGoldEarned += goldValues.poll();
                        if (!goldValues.isEmpty()) { // if there are no more values, no point adding back
                            quests.put(X, goldValues);
                        }
                        break;
                    } else {
                        Integer lowerKey = quests.lowerKey(X);
                        if (lowerKey != null) {
                            X -= lowerKey;
                            PriorityQueue<Long> goldValues = quests.remove(lowerKey);
                            totalGoldEarned += goldValues.poll();
                            if (!goldValues.isEmpty()) { // if there are no more values, no point adding back
                                quests.put(lowerKey, goldValues);
                            }
                        } else { // kattis cat has insufficient energy to do another quest
                            break;
                        }
                    }
                }
                io.println(totalGoldEarned);
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
