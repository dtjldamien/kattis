
// https://open.kattis.com/problems/jollyjumpers
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.StringBuilder;

public class BasicProgramming1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int t = Integer.parseInt(firstLine[1]);
        if (t == 1) {
            pw.println("7");
        } else {
            String[] secondLine = br.readLine().split(" ");
            int[] arr = new int[n];
            long sum = 0;
            long sumEven = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(secondLine[i]);
                sum += arr[i];
                if (arr[i] % 2 == 0) {
                    sumEven += arr[i];
                }
                sb.append((char) (arr[i] % 26 + 'a'));
            }
            if (t == 2) {
                if (arr[0] > arr[1]) {
                    pw.println("Bigger");
                } else if (arr[0] == arr[1]) {
                    pw.println("Equal");
                } else {
                    pw.println("Smaller");
                }
            } else if (t == 3) {
                if ((arr[0] > arr[1] && arr[0] < arr[2]) || (arr[0] < arr[1] && arr[0] > arr[2])) {
                    pw.println(arr[0]);
                } else if ((arr[1] > arr[2] && arr[1] < arr[0]) || (arr[1] < arr[2] && arr[1] > arr[0])) {
                    pw.println(arr[1]);
                } else {
                    pw.println(arr[2]);
                }
            } else if (t == 4) {
                pw.println(sum);
            } else if (t == 5) {
                pw.println(sumEven);
            } else if (t == 6) {
                pw.println(sb.toString());
            } else if (t == 7) {
                int idx = 0;
                boolean[] visited = new boolean[n];
                visited[0] = true;
                while (true) {
                    idx = arr[idx];
                    if (idx >= n) {
                        pw.println("Out");
                        break;
                    } else if (idx == n - 1) {
                        pw.println("Done");
                        break;
                    } else if (visited[idx]) {
                        pw.println("Cyclic");
                        break;
                    }
                    visited[idx] = true;
                }
            }
        }
        pw.close();
        br.close();
    }
}
