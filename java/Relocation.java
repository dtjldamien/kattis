// https://open.kattis.com/problems/relocation
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Relocation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int Q = Integer.parseInt(firstLine[1]);
        int[] locations = new int[N];
        String[] secondLine = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            locations[i] = Integer.parseInt(secondLine[i]);
        }
        for (int i = 0; i < Q; i++) {
            String[] nextLine = br.readLine().split(" ");
            if (Integer.parseInt(nextLine[0]) == 1) {
                // company C moves its location to X
                locations[Integer.parseInt(nextLine[1]) - 1] = Integer.parseInt(nextLine[2]);
            } else {
                // query
                pw.println(Math.abs(locations[Integer.parseInt(nextLine[1]) - 1] - locations[Integer.parseInt(nextLine[2]) - 1]));
            }
        }
        pw.close();
        br.close();
    }
}