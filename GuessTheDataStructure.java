import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GuessTheDataStructure {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        while (io.hasMoreTokens()) {
            int n = io.getInt();
            Stack<Integer> stack = new Stack<>();
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            Comparator<Integer> largestFirst = new Comparator<Integer>() {
                @Override
                public int compare (Integer int1, Integer int2) {
                    return int2 - int1;
                }
            };
            PriorityQueue<Integer> pq = new PriorityQueue<>(largestFirst);    
            boolean isPriorityQueue = true;
            boolean isQueue = true;
            boolean isStack = true;
            boolean hasException = false;
            for (int i = 0; i < n; i++) {
                int command = io.getInt();
                int x = io.getInt();
                if (command == 1) {
                    stack.push(x);
                    queue.add(x);
                    pq.add(x);
                } else {
                    try {
                        int stackX = stack.pop();
                        int queueX = queue.poll();
                        int pqX = pq.poll();
                        /*
                        io.println("stack " + stackX);
                        io.println("queue " + queueX);
                        io.println("pq " + pqX);
                        */
                        if (stackX != x) {
                            isStack = false;
                        }
                        if (queueX != x) {
                            isQueue = false;
                        }
                        if (pqX != x) {
                            isPriorityQueue = false;
                        }
                    } catch (Exception e) {
                        hasException = true;
                    }
                }
            }
            if (hasException || !isStack && !isQueue && !isPriorityQueue) {
                io.println("impossible");
            } else if (isStack && isQueue && isPriorityQueue || isStack && isQueue || isStack && isPriorityQueue || isQueue && isPriorityQueue) {
                io.println("not sure");
            } else if (isStack) {
                io.println("stack");
            } else if (isQueue) {
                io.println("queue");
            } else {
                io.println("priority queue");
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