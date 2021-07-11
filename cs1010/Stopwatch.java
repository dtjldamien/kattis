import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Stopwatch {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine()); // number of times the stopwatch was pressed
        if (n % 2 == 1) {
            pw.println("still running");
        } else {
            int timeStarted = 0; // tracks the time timer was on
            int timeStopped = 0; // tracks the time timer was stopped
            int timeStopwatch = 0; // tracks the time on stopwatch
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    timeStarted = Integer.parseInt(br.readLine());
                } else {
                    timeStopped = Integer.parseInt(br.readLine());
                    timeStopwatch = timeStopwatch + timeStopped - timeStarted;
                }
            }
            pw.println(timeStopwatch);
        }
        pw.close();
        br.close();
    }
}
