// https://open.kattis.com/problems/touchscreenkeyboard
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;

public class TouchscreenKeyboard {

    static String row1 = "qwertyuiop";
    static String row2 = "asdfghjkl";
    static String row3 = "zxcvbnm";

    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            String word = input[0];
            int l = Integer.parseInt(input[1]);
            ArrayList<SpellChecker> list = new ArrayList<>();
            for (int j = 0; j < l; j++) {
                String spellcheck = br.readLine();
                int totalDist = 0;
                for (int k = 0; k < word.length(); k++) {
                    char charWord = word.charAt(k);
                    int wordRow = getRow(charWord);
                    int wordCol = getCol(wordRow, charWord);
                    char charSpellcheck = spellcheck.charAt(k);
                    int spellcheckRow = getRow(charSpellcheck);
                    int spellcheckCol = getCol(spellcheckRow, charSpellcheck);
                    totalDist += Math.abs(wordRow - spellcheckRow) + Math.abs(wordCol - spellcheckCol);
                }
                list.add(new SpellChecker(spellcheck, totalDist));
            }
            Collections.sort(list);
            for (SpellChecker sc : list) {
                pw.printf("%s %d\n", sc.word, sc.distance);
            }
        }
        pw.close();
        br.close();
    }

    public static int getRow(char a) {
        if (row1.contains("" + a)) {
            return 1;
        } else if (row2.contains("" + a)) {
            return 2;
        } else {
            return 3;
        }
    }

    public static int getCol(int row, char a) {
        if (row == 1) {
            return row1.indexOf("" + a);
        } else if (row == 2) {
            return row2.indexOf("" + a);
        } else {
            return row3.indexOf("" + a);
        }
    }
}

class SpellChecker implements Comparable<SpellChecker> {
    String word; 
    int distance;

    public SpellChecker(String word, int distance) {
        this.word = word;
        this.distance = distance;
    }

    @Override
    public int compareTo(SpellChecker another) {
        if (this.distance - another.distance == 0) {
            return this.word.compareTo(another.word);
        } else {
            return this.distance - another.distance;
        }
    }
}