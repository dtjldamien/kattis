
// https://open.kattis.com/problems/natrij
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Natrij {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] currentTime = br.readLine().split(":");
        String[] explosionTime = br.readLine().split(":");

        int currentTimeInSeconds = Integer.parseInt(currentTime[0]) * 3600 + Integer.parseInt(currentTime[1]) * 60 + Integer.parseInt(currentTime[2]);
        int explosionTimeInSeconds = Integer.parseInt(explosionTime[0]) * 3600 + Integer.parseInt(explosionTime[1]) * 60 + Integer.parseInt(explosionTime[2]);

        if (currentTimeInSeconds == explosionTimeInSeconds) {
            // corner case
            pw.println("24:00:00");
        } else {
            int timeDifferenceInSeconds = explosionTimeInSeconds - currentTimeInSeconds;
            if (currentTimeInSeconds > explosionTimeInSeconds) {
                timeDifferenceInSeconds += 86400;
            }
            int hours = timeDifferenceInSeconds / 3600;
            timeDifferenceInSeconds %= 3600;
            int minutes = timeDifferenceInSeconds / 60;
            timeDifferenceInSeconds %= 60;
            pw.printf("%02d:%02d:%02d\n", hours, minutes, timeDifferenceInSeconds);
        }

        pw.close();
        br.close();
    }
}