package java;
// https://open.kattis.com/problems/keytocrypto
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class KeyToCrypto {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String cipher = br.readLine();
        StringBuilder secret = new StringBuilder(br.readLine());
        StringBuilder origMessage = new StringBuilder();
        for (int i = 0; i < cipher.length(); i++) {
            int curr = cipher.charAt(i) + 'A' - secret.charAt(i);
            if (curr < 'A') {
                curr += 26;
            }
            char currChar = (char) curr;
            secret.append(currChar);
            origMessage.append(currChar);
        }
        pw.println(origMessage.toString());
        pw.close();
        br.close();
    }
}
