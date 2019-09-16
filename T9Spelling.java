import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;

public class T9Spelling {
    public static void main(String[] args) throws Exception {
        String[] dict = new String[128];
        dict['a'] = "2";
        dict['b'] = "22";
        dict['c'] = "222";
        dict['d'] = "3";
        dict['e'] = "33";
        dict['f'] = "333";
        dict['g'] = "4";
        dict['h'] = "44";
        dict['i'] = "444";
        dict['j'] = "5";
        dict['k'] = "55";
        dict['l'] = "555";
        dict['m'] = "6";
        dict['n'] = "66";
        dict['o'] = "666";
        dict['p'] = "7";
        dict['q'] = "77";
        dict['r'] = "777";
        dict['s'] = "7777";
        dict['t'] = "8";
        dict['u'] = "88";
        dict['v'] = "888";
        dict['w'] = "9";
        dict['x'] = "99";
        dict['y'] = "999";
        dict['z'] = "9999";
        dict[' '] = "0";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Case #%d: ", i));
            String input = br.readLine();
            sb.append(dict[input.charAt(0)]);
            for (int j = 1; j < input.length(); j++) {
                if (dict[input.charAt(j)].charAt(1) == dict[input.charAt(j-1)].charAt(0)) {
                    sb.append(" ");
                }
                sb.append(dict[input.charAt(j)]);
            }
            pw.println(sb.toString());
        }
        br.close();
        pw.close();
    }
}