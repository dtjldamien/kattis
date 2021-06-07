// https://open.kattis.com/problems/echoechoecho
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EchoEchoEcho {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String input = br.readLine();
        pw.printf("%s %s %s\n", input, input, input);
        pw.close();
        br.close();
    }
}
