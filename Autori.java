import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder;

public class Autori {
    public static void main(String[] args) throws  Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String[] words = br.readLine().split("-");
        StringBuilder sb = new  StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i].charAt(0));
        }
        System.out.println(sb);
    }
}