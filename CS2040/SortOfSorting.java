import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SortOfSorting {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            String[] students = new String[n];
            for (int i = 0; i < n; i++) {
                students[i] = br.readLine();
            }
            mergeSort(students, 0, students.length - 1);
            for (String student : students) {
                pw.println(student);
            }
            pw.println();
            n = Integer.parseInt(br.readLine());
        }
        pw.close();
        br.close();
    }

    public static void mergeSort(String[] students, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            mergeSort(students, i, mid);
            mergeSort(students, mid + 1, j);
            merge(students, i, mid, j);
        }
    }

    public static void merge(String[] students, int i, int mid, int j) {
        // Merge the 2 sorted sub-arrays [i..mid] and a[mid+1..j]
        // into one sorted sub-array a[i..j]
        String[] temp = new String[j - i + 1]; // temp storage
        int left = i, right = mid + 1, it = 0;
        // it = next index to store merged item in temp[]

        while (left <= mid && right <= j) {
            if (students[left].charAt(0) < students[right].charAt(0)) {
                temp[it++] = students[left++];
            } else if (students[left].charAt(0) > students[right].charAt(0)) {
                temp[it++] = students[right++];
            } else { // charAt(0) is the same
                if (students[left].charAt(1) <= students[right].charAt(1)) {
                    temp[it++] = students[left++];
                } else {
                    temp[it++] = students[right++];
                }
            }
        }

        // Copy the remaining elements into temp
        while (left <= mid) {
            temp[it++] = students[left++];
        }
        while (right <= j) {
            temp[it++] = students[right++];
        }

        // Copy the result in temp back into the original array
        for (int k = 0; k < temp.length; k++) {
            students[i + k] = temp[k];
        }
    }
}