import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.PriorityQueue;

public class BallotBoxes {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        while (true) {
            int N = io.getInt();
            if (N == -1) {
                break;
            } else {
                int B = io.getInt();
                PriorityQueue<City> cities = new PriorityQueue<>();
                for (int i = 0; i < N; i++) {
                    cities.add(new City(io.getInt()));
                }
                int numBallotBoxesLeft = B - N;
                while (numBallotBoxesLeft > 0) {
                    City city = cities.poll();
                    city.addBallotBox();
                    numBallotBoxesLeft--;
                    cities.add(city);
                }
                City city = cities.peek();
                io.println((int) Math.ceil(city.populationPerBallotBox));
            }
        }
        io.close();
     }
}

class City implements Comparable<City> {
    int population;
    int numBallotBox;
    double populationPerBallotBox;

    public City (int size) {
        this.population = size; 
        this.numBallotBox = 1;
        this.populationPerBallotBox = population;
    }

    public void addBallotBox() {
        this.numBallotBox++;
        this.populationPerBallotBox = 1.0 * population / numBallotBox;
    }

    @Override
    public int compareTo(City another) { // bigger popn in front
        if (this.populationPerBallotBox > another.populationPerBallotBox) {
            return -1;
        } else {
            return 1;
        }
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
