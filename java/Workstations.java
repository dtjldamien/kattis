import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Workstations {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); // number of researchers
        int m = io.getInt(); // m minutes before the workstation locks
        int count = 0; // number of unlockings Penelope may save herself
        PriorityQueue<Researcher> pqResearchers = new PriorityQueue<>(); // researchers sorted according to their arrival time
        for (int i = 0; i < n; i++) {
            int a = io.getInt(); // time researcher arrives
            int s = io.getInt(); // time researcher stays
            pqResearchers.add(new Researcher(a, s));
        }
        PriorityQueue<Integer> pqWorkstations = new PriorityQueue<>(); // workstations according to the time they are free for use
        for (int i = 0; i < n; i++) {
            int currTime = pqResearchers.peek().arrivalTime; // time of the arrival of the next researcher
            while (!pqWorkstations.isEmpty()) {
                if (pqWorkstations.peek() + m < currTime) { // free workstations are locked just before the arrival of the next researcher
                    pqWorkstations.poll();
                } else {
                    break; // no free workstations just before the arrival of the next researcher
                }
            }
            if (pqWorkstations.isEmpty()) {
                // to avoid null pointer exception
            } else if (pqWorkstations.peek() <= pqResearchers.peek().arrivalTime && pqResearchers.peek().arrivalTime <= pqWorkstations.peek() + m) {
                // next researcher arrives within m minutes after the previous researcher was done (done <= arrival <= done + m)
                count++;
                pqWorkstations.poll();
            }
            pqWorkstations.add(pqResearchers.poll().departureTime);
        }
        io.print(count);
        io.close();
    }
}

class Researcher implements Comparable<Researcher> {
    int arrivalTime;
    int departureTime; // arrival time + usage time

    public Researcher (int a, int s) {
        arrivalTime = a;
        departureTime = a + s;
    }

    @Override 
    public int compareTo(Researcher another) {
        return this.arrivalTime - another.arrivalTime;
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
