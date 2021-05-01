// https://open.kattis.com/problems/drmmessages
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DRMMessages {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String input = br.readLine();
        char[] firstHalf = input.substring(0, input.length() / 2).toCharArray();
        char[] secondHalf = input.substring(input.length() / 2, input.length()).toCharArray();

        int sumFirstHalf = 0;
        int sumSecondHalf = 0;

        // guaranteed to have the same length since the string's length is even
        for (int i = 0; i < firstHalf.length; i ++) {
            sumFirstHalf += firstHalf[i] - 'A';
            sumSecondHalf += secondHalf[i] - 'A';
        }

        char[] rotatedFirstHalf = new char[firstHalf.length];
        char[] rotatedSecondHalf = new char[secondHalf.length];
        char[] decryptedMessage = new char[firstHalf.length];

        for (int i = 0; i < firstHalf.length; i ++) {
            rotatedFirstHalf[i] =  (char) ((firstHalf[i] - 'A' + sumFirstHalf) % 26 + 'A');
            rotatedSecondHalf[i] =  (char) ((secondHalf[i] - 'A' + sumSecondHalf) % 26 + 'A');
            decryptedMessage[i] =  (char) ((rotatedFirstHalf[i] - 'A' + rotatedSecondHalf[i] - 'A') % 26 + 'A');
            pw.print(decryptedMessage[i]);
        }
        pw.close();
        br.close();
    }
}