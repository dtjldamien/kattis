
// https://open.kattis.com/problems/icpcawards
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class ICPCAwards {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine()); // number of teams
        String[] input;
        String university;
        String team;
        HashSet<String> set = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            while (set.size() < 12) {
                input = br.readLine().split(" ");
                university = input[0];
                team = input[1];
                if (!set.contains(university)) {
                    pw.printf("%s %s\n", university, team);
                    set.add(university);
                }
            }
        }
        pw.close();
        br.close();
    }
}