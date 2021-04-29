// https://open.kattis.com/problems/ofugsnuid
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class Ofugsnuid {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }
        while (!stack.empty()) {
            pw.println(stack.pop());
        }
        pw.close();
        br.close();
    }    
}
