import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;

public class WheresMyInternet {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); // number of houses
        int m = io.getInt(); // number of network cables

        List<House> houses = new ArrayList<>();
        for (int i = 0; i < n; i++) { // to make house number 0 based
            houses.add(new House(i));
        }
        for (int i = 0; i < m; i++) {
            int houseNumberA = io.getInt() - 1;
            int houseNumberB = io.getInt() - 1;
            House houseA = houses.get(houseNumberA);
            House houseB = houses.get(houseNumberB);
            houseA.linkedHouses.add(houseB);
            houseB.linkedHouses.add(houseA);
        }

        connectHouse(houses.get(0));

        boolean allConnected = true;
        for (House house : houses) {
            if (house.connected == false) {
                allConnected = false;
                io.println(house.houseNumber + 1);
            }
        }
        if (allConnected) {
            io.println("Connected");
        }
        io.close();
    }

    public static void connectHouse(House house) {
        if (house.connected == true) {
            return;
        }
        house.connected = true;
        for (House otherHouse : house.linkedHouses) {
            connectHouse(otherHouse);
        }
    }
}

class House {
    public int houseNumber;
    public List<House> linkedHouses; // sort of an adjacency list
    public boolean connected;

    public House(int houseNumber) {
        this.houseNumber = houseNumber;
        this.linkedHouses = new ArrayList<>();
        this.connected = false;
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
