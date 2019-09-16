import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TrainPassengers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int capacity = Integer.parseInt(input[0]);
        int numStations = Integer.parseInt(input[1]);
        int numPassengers = 0;
        boolean possible = true;
        String[] stationInfo;
        int numLeft;
        int numEntered;
        int numStayed;
        // start and end empty, passengers should not wait at the last station
        for (int i = 0; i < numStations; i++) {
            stationInfo = br.readLine().split(" ");
            numLeft = Integer.parseInt(stationInfo[0]);
            numEntered = Integer.parseInt(stationInfo[1]);
            numStayed = Integer.parseInt(stationInfo[2]);
            numPassengers = numPassengers - numLeft + numEntered;
            if (numStayed > 0 && numPassengers < capacity) {
                possible = false;
                break;
            } else if (i == 0 && numLeft > 0) {
                possible = false;
                break;
            } else if (numPassengers > capacity) {
                possible = false;
                break;
            }
        }
        if (numPassengers > 0) {
            possible = false;
        }
        if (possible) {
            pw.println("possible");
        } else {
            pw.println("impossible");
        }
        pw.close();
        br.close();
    }
}