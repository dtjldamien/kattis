import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.PriorityQueue;

public class ZipfSong {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); // number of songs on the album
        int m = io.getInt(); // number of songs to select
        PriorityQueue<Song> songsByQuality = new PriorityQueue<>();
        for (int i =  1; i <= n; i++) {
            double f = io.getDouble(); // number of times the song has been played
            String s = io.getWord(); // name of the song
            songsByQuality.add(new Song(f, s, i));
        }
        for (int i = 0; i < m; i++) {
            Song song = songsByQuality.poll();
            io.println(song.name);
        }
        io.close();
    }
}

class Song implements Comparable<Song>{
    double plays;
    String name;
    int i;
    double quality; 

    public  Song(double f, String s, int i) {
        this.plays = f;
        this.name = s;  
        this.i = i;
        this.quality = f * i;
    }

    @Override
    public int compareTo(Song another) {
        if (another.quality < this.quality) { // sort songs by quality in descending order
            return -1;
        } else if (another.quality > this.quality) {
            return 1;
        } else { // return song that first appears, have more predicted plays if it comes first
            return this.i - another.i; 
        }
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
