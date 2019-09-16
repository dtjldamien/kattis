import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BestRelayTeam {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        ArrayList<Runner> runners = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            runners.add(new Runner(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2])));
        }
        Collections.sort(runners);
        double fastest = Double.MAX_VALUE;
        int[] team = new int[4];
        double timing = 0;
        int secondIdx;
        int thirdIdx;
        int fourthIdx;
        for (int firstIdx = 0; firstIdx < n; firstIdx++) {
            timing = runners.get(firstIdx).firstLeg;
            if (firstIdx == 0) {
                timing += runners.get(1).secondLeg + runners.get(2).secondLeg + runners.get(3).secondLeg;
                secondIdx = 1;
                thirdIdx = 2;
                fourthIdx = 3;
            } else if (firstIdx == 1) {
                timing += runners.get(0).secondLeg + runners.get(2).secondLeg + runners.get(3).secondLeg;
                secondIdx = 0;
                thirdIdx = 2;
                fourthIdx = 3;
            } else if (firstIdx == 2) {
                timing += runners.get(0).secondLeg + runners.get(1).secondLeg + runners.get(3).secondLeg;
                secondIdx = 0;
                thirdIdx = 1;
                fourthIdx = 3;
            } else {
                timing += runners.get(0).secondLeg + runners.get(1).secondLeg + runners.get(2).secondLeg;
                secondIdx = 0;
                thirdIdx = 1;
                fourthIdx = 2;
            }
            if (timing < fastest) {
                fastest = timing;
                team[0] = firstIdx;
                team[1] = secondIdx;
                team[2] = thirdIdx;
                team[3] = fourthIdx;
            }
        }
        pw.println(String.format("%.2f%n%s%n%s%n%s%n%s", fastest, runners.get(team[0]).name, runners.get(team[1]).name,
                runners.get(team[2]).name, runners.get(team[3]).name));
        pw.close();
    }
}

class Runner implements Comparable<Runner> {
    public String name;
    public double firstLeg;
    public double secondLeg;

    public Runner(String name, double firstLeg, double secondLeg) {
        this.name = name;
        this.firstLeg = firstLeg;
        this.secondLeg = secondLeg;
    }

    @Override
    public int compareTo(Runner another) {
        if (this.secondLeg < another.secondLeg) {
            return -1;
        } else {
            return 1;
        }
    }
}