import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class DelimiterSoup {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        char[] l = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<Character>();
        boolean hasError = false;
        for (int i = 0; i < n; i++) {
            if (l[i] == '(' || l[i] == '[' || l[i] == '{') {
                stack.push(l[i]);
            } else if (l[i] == ' ') {
            } else {
                if (stack.isEmpty()) {
                    hasError = true;
                    pw.println(l[i] + " " + i);
                    break;
                }
                if ((stack.peek() == '(' && l[i] == ')') || (stack.peek() == '[' && l[i] == ']') || (stack.peek() == '{' && l[i] == '}')) {
                    stack.pop();
                } else {
                    hasError = true;
                    pw.println(l[i] + " " + i);
                    break;
                }
            }
        }
        if (!hasError) {
            pw.println("ok so far");
        }
        pw.close();
        br.close();
    }
}