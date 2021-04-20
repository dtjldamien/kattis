// https://open.kattis.com/problems/simonsays
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SimonSays {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine()); // number of commands
        String command;

        for (int i = 0; i < n; i++) {
            command = br.readLine();
            if (command.contains("Simon says")) {
                pw.println(command.substring(10));
            }
        }

        pw.close();
        br.close();
    }
}