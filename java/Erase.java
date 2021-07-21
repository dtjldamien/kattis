// https://open.kattis.com/problems/erase
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Erase {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        char[] originalFile = br.readLine().toCharArray();
        char[] deletedFile = br.readLine().toCharArray();
        boolean isSuccessful = true;
        if (n % 2 == 0) {
            for (int i = 0; i < originalFile.length; i++) {
                if (originalFile[i] != deletedFile[i]) {
                    isSuccessful = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < originalFile.length; i++) {
                if (originalFile[i] == deletedFile[i]) {
                    isSuccessful = false;
                    break;
                }
            }
        }
        if (isSuccessful) {
            pw.println("Deletion succeeded");
        } else {
            pw.println("Deletion failed");
        }
        pw.close();
        br.close();
    }
}