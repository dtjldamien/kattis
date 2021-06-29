
// https://open.kattis.com/problems/measurement
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class EngineeringEnglish {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        HashSet<String> hashSet = new HashSet<>();
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (hashSet.contains(words[i].toLowerCase())) {
                    pw.print(". ");
                } else {
                    hashSet.add(words[i].toLowerCase());
                    pw.printf("%s ", words[i]);
                }
            }
            pw.println();
        }
        pw.close();
        br.close();
    }
}
