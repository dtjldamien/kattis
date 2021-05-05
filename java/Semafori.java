// https://open.kattis.com/problems/semafori
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Semafori {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
    
            String[] firstLine = br.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int l = Integer.parseInt(firstLine[1]);
    
            String[] input;
            int d = 0; // distance of the traffic light from the start of the road
            int r = 0; // duration of red light
            int g = 0; // duration of green light
    
            // when luka starts, all lights are red
            int currentTime = 0;
            int prevD = 0;
            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                d = Integer.parseInt(input[0]);
                r = Integer.parseInt(input[1]);
                g = Integer.parseInt(input[2]);
    
                currentTime = currentTime + d - prevD;
                if (currentTime % (r + g) < r) {
                    currentTime += r - (currentTime % (r + g));
                }
                prevD = d;
            }
            currentTime = currentTime + l - prevD;
            pw.println(currentTime);
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
