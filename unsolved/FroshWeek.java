import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class FroshWeek {

    // https://www.geeksforgeeks.org/number-swaps-sort-adjacent-swapping-allowed/
    public long inversions;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int[] arr = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = io.getInt();
            temp[i] = arr[i];
        }
        long numSwaps = mergeSort(arr, temp, 0, n - 1);
        io.println(numSwaps);
        io.close();
    }
    
    public static long mergeSort(int[] arr, int[] temp, int i, int j) {
        long swapCount = 0;
        if (i < j) {
            int mid= (i+j)/2;
            swapCount = mergeSort(arr, temp, i, mid);
            swapCount += mergeSort(arr, temp, mid+1, j);
            swapCount += merge(arr, temp, i, mid, j);
        }
        return swapCount;
    }

    public static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        long swapCount = 0;
        // Merges the 2 sorted sub-arrays a[i..mid] and a[mid+1..j] 
        // into one sorted sub-array a[i..j]
        int i = left, j = mid, k = left;
        // it = next index to store merged item in temp[]

        while (i<= mid - 1 && j<= right) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
                swapCount = swapCount + (mid - i); 
        }

        // Copy the remaining elements into temp.
        while (i<=mid - 1) temp[k++] = arr[i++];

        // Copy the result in temp back into the original array a
        for (int m = left; m <= right; m++)
            arr[m] = temp[m];

        return swapCount;
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