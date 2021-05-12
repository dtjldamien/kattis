// https://open.kattis.com/problems/vauvau
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class SymmetricOrder {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int setCounter = 0;
        Stack<String> stack = new Stack<String>();
        while (n != 0) {
            setCounter++;
            pw.printf("SET %d\n", setCounter);
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    stack.push(br.readLine());
                } else {
                    pw.println(br.readLine());
                }
            }
            while (!stack.isEmpty()) {
                pw.println(stack.pop());
            }
            n = Integer.parseInt(br.readLine());
        }
        pw.close();
        br.close();
    }
}
