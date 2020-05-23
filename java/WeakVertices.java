import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class WeakVertices {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        while (n != -1) {
            String[][] graph = new String[n][n];
            for (int i = 0; i < n; i++) {
                graph[i] = br.readLine().split(" ");
            }
            for (int i = 0; i < n; i++) {
                if(hasTriangle(graph, i)) {
                    continue;
                } else {
                    pw.print(i + " ");
                }
            }
            pw.println();
            n = Integer.parseInt(br.readLine());
        }
        pw.close();
        br.close();
    }

    public static boolean hasTriangle(String[][] graph, int i) {
        for (int j = 0; j < graph[0].length; j++) {
            if (graph[i][j].equals("1")) {
                for (int k = j + 1; k < graph[0].length; k++) {
                    if (graph[i][k].equals("1") && graph[j][k].equals("1")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}