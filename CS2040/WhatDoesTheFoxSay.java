import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WhatDoesTheFoxSay {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] recording = br.readLine().split(" ");
            ArrayList<String> notFoxSounds = new ArrayList<>();
            String nextLine = br.readLine();
            while (!nextLine.equals("what does the fox say?")) {
                String[] input = nextLine.split(" ");
                notFoxSounds.add(input[2]);
                nextLine = br.readLine();
            }
            for (String sound : recording) {
                if (!notFoxSounds.contains(sound)) {
                    System.out.print(sound + " ");
                }
            }
        }
        pw.close();
        br.close();
    }
}