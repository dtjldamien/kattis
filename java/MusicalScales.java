package java;
// https://open.kattis.com/problems/musicalscales
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class MusicalScales {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] notes = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
        HashSet<String> notesPlayed = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            notesPlayed.add(input[i]);
        }
        List<String> fittingScales = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            List<String> scale = new ArrayList<>();
            scale.add(notes[i]);
            scale.add(notes[(i+2)%12]);
            scale.add(notes[(i+4)%12]);
            scale.add(notes[(i+5)%12]);
            scale.add(notes[(i+7)%12]);
            scale.add(notes[(i+9)%12]);
            scale.add(notes[(i+11)%12]);
            Iterator<String> notesPlayedIter = notesPlayed.iterator();
            boolean isFit = true;
            while(notesPlayedIter.hasNext()) {
                String currNote = notesPlayedIter.next();
                if (!scale.contains(currNote)) {
                    isFit = false;
                    break;
                }
            }    
            if (isFit) {
                fittingScales.add(notes[i]);
            }
        }
        if (fittingScales.size() == 0) {
            pw.println("none");
        } else {
            String output = fittingScales.toString().replace("[", "").replace("]", "").replace(",", "");
            pw.println(output);
        }
        pw.close();
        br.close();
    }
}
