// https://open.kattis.com/problems/synchronizinglists
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class SynchronizingLists {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            int n = Integer.parseInt(br.readLine());
            while (n != 0) {
                int[] firstList = new int[n];
                int[] firstSortedList = new int[n];
                int[] secondList = new int[n];
                int[] secondSortedList = new int[n];
                for (int i = 0; i < n; i++) {
                    firstList[i] = Integer.parseInt(br.readLine());
                    firstSortedList[i] = firstList[i];
                }
                Arrays.sort(firstSortedList);
                for (int i = 0; i < n; i++) {
                    secondList[i] = Integer.parseInt(br.readLine());
                    secondSortedList[i] = secondList[i];
                }
                Arrays.sort(secondSortedList);
                for (int i = 0; i < n; i++) {
                    int curr = firstList[i];
                    int idx = binarySearch(firstSortedList, curr, 0, n - 1);
                    pw.println(secondSortedList[idx]);  
                }
                pw.println();
                n = Integer.parseInt(br.readLine());
            }
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int binarySearch(int[] arr, int i, int start, int end) {
        int mid = (start + end) / 2;
        if (arr[mid] == i) {
            return mid;
        } else if (arr[mid] > i) {
            return binarySearch(arr, i, start, mid - 1);
        } else {
            return binarySearch(arr, i, mid + 1, end);
        }
    }
}