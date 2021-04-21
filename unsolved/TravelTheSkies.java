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

public class TravelTheSkies {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int k = io.getInt(); // number of airports
        int n = io.getInt(); // number of days of the flight departure window
        int m = io.getInt(); // number of flights in the window
        List<List<Flight>> flights = new ArrayList<>();
        List<List<Demand>> demands = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            flights.add(new ArrayList<Flight>());
            demands.add(new ArrayList<Demand>());
        }
        for (int i = 0; i < m; i++) {
            int u = io.getInt() - 1; // flights starting location
            int v = io.getInt() - 1; // flights ending destination
            int d = io.getInt() - 1; // day on which the flight flies in the window
            int z = io.getInt(); // capacity of the flight
            flights.get(d).add(new Flight(u, v, z));
        }
        for (int i = 0; i < k * n; i++) {
            int a = io.getInt() - 1; // the airport
            int b = io.getInt() - 1; // the day
            int c = io.getInt(); // number of customers at airport a on day b
            demands.get(b).add(new Demand(a, c));
        }
        // check if they can leave
        boolean isOptimal = false;
        for (int i = 0; i < n; i++) {
            List<Flight> currentDayFlights = flights.get(i);
            List<Demand> currentDayDemands = demands.get(i);
            for (int j = 0; j < k; j++) { // iterate through the airports
                int totalDemand = 0;
                for (Demand demand : currentDayDemands) {
                    if (demand.airport == j) {
                        totalDemand += demand.numCustomers;
                    }
                }
                for (Flight flight : currentDayFlights) {
                    if (flight.startingLocation == j) {
                        if (totalDemand < flight.capacity) {
                            isOptimal = false;
                            break;
                        } else { // totalDemand >= flight.capacity
                            isOptimal = true;
                            if (i + 1 < n) {
                                totalDemand -= flight.capacity;
                                demands.get(i + 1).add(new Demand(flight.startingLocation, totalDemand));
                                demands.get(i + 1).add(new Demand(flight.endingDestination, flight.capacity));
                            }
                        }
                    }
                }
                if (i + 1 < n) {
                    demands.get(i + 1).add(new Demand(j, totalDemand));
                }
            }
        }
        if (isOptimal) {
            io.println("optimal");
        } else {
            io.println("suboptimal");
        }
        io.close();
    }
}

class Demand {

    public int airport;
    public int numCustomers;

    public Demand(int airport, int numCustomers) {
        this.airport = airport;
        this.numCustomers = numCustomers;
    }
}

class Flight {

    public int startingLocation;
    public int endingDestination;
    public int capacity;

    public Flight(int startingLocation, int endingDestination, int capacity) {
        this.startingLocation = startingLocation;
        this.endingDestination = endingDestination;
        this.capacity = capacity;
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
