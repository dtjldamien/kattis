
// https://open.kattis.com/problems/kitten
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class Kitten {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int k = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (true) {
            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            if (parent != -1) {
                for (int i = 1; i < input.length; i++) {
                    map.put(Integer.parseInt(input[i]), parent);
                }
            } else {
                break;
            }
        }
        int s = k;
        while (true) {
            pw.printf("%d ", s);
            s = map.get(s);
            if (!map.containsKey(s)) {
                break;
            }
        }
        pw.println(s);
        pw.close();
        br.close();
    }
}
