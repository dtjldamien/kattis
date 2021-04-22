
// https://open.kattis.com/problems/mandelbrot
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Mandelbrot {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio(System.in, System.out);

        int case_num = 1;
        double x;
        double y;
        int r;
        boolean hasDiverged = false;
        ComplexNumber z;
        ComplexNumber c;
        while (io.hasMoreTokens()) {
            x = io.getDouble(); // real
            y = io.getDouble(); // imaginary
            r = io.getInt(); // maximum number of iterations to compute
            z = new ComplexNumber(0, 0); // begin with z0 = 0
            c = new ComplexNumber(x, y);
            hasDiverged = false;
            for (int i = 0; i <= r; i++) {
                if (z.mod() > 2) {
                    hasDiverged = true;
                    break;
                } else {
                    z.square();
                    z.add(c);
                }
            }
            if (hasDiverged) {
                io.printf("Case %d: OUT\n", case_num);
            } else {
                io.printf("Case %d: IN\n", case_num);
            }
            case_num++;
        }
        io.close();
    }
}

class ComplexNumber {
    public double real;
    public double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void square() {
        double tempReal = this.real;
        this.real = tempReal * tempReal - this.imaginary * this.imaginary;
        this.imaginary = 2 * tempReal * this.imaginary;
    }

    public double mod() {
        // Math.hypot returns sqrt(x^2  + y^2)
        return Math.hypot(this.real, this.imaginary);
    }

    public void add(ComplexNumber other) {
        this.real = this.real + other.real;
        this.imaginary = this.imaginary + other.imaginary;
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
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
            }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
