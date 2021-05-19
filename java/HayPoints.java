// https://open.kattis.com/problems/haypoints
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Hashtable;

public class HayPoints {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]); // the number of words in the Hay Point dictionary
        int n = Integer.parseInt(input[1]); // the number of job description m lines follow

        Hashtable<String, Integer> hayPoint = new Hashtable<>();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            hayPoint.put(input[0], Integer.parseInt(input[1]));
        }

        for (int i = 0; i < n; i++) {
            int salary = 0;
            String description = br.readLine();
            while (!description.equals(".")) {
                input = description.split(" ");
                for (int j = 0; j < input.length; j++) {
                    if (hayPoint.containsKey(input[j])) {
                        salary += hayPoint.get(input[j]);
                    }
                }
                description = br.readLine();
            }
            pw.println(salary);
        }
        pw.close();
        br.close();
    }
}