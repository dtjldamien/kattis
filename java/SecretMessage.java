// https://open.kattis.com/problems/secretmessage
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SecretMessage {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String message = br.readLine();
            char[][] table = fillTable(message);
            printEncryptedMessage(pw, table);
        }
        br.close();
        pw.close();
    }

    public static int getSmallestSquare(int x) {
        int root = (int) Math.round(Math.sqrt(x));
        if (root * root >= x) {
            return root;
        } else {
            return root + 1;
        }
    }

    public static char[][] fillTable(String message) {
        int m = getSmallestSquare(message.length());
        char[][] table = new char[m][m];
        int idx = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < m; col++) {
                if (idx < message.length()) {
                    table[row][col] = message.charAt(idx);
                    idx++;
                } else {
                    table[row][col] = '*';
                }
            }
        }
        return table;
    }

    public static void printEncryptedMessage(PrintWriter pw, char[][] table) {
        // print matrix 90 degrees clockise
        for (int col = 0; col < table[0].length; col++) {
            for (int row = table[0].length - 1; row >= 0; row--) {
                if (table[row][col] != '*') {
                    pw.print(table[row][col]);
                }
            }
        }
        pw.println();
    }
}
