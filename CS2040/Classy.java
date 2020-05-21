import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.lang.StringBuilder;

public class Classy {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numCases = Integer.parseInt(br.readLine());
        PeopleComparator pc = new PeopleComparator();
        int maxLength = 0;
        for (int i = 0; i < numCases; i++) {
            int numPeople = Integer.parseInt(br.readLine());
            List<Person> people = new ArrayList<>();
            for (int j = 0; j < numPeople; j++) {
                String[] input = br.readLine().split(" ");
                String name = input[0].substring(0, input[0].length() - 1);
                String[] statusArr = input[1].split("-");
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < statusArr.length; k++) {
                    if (statusArr[k].equals("upper")) {
                        sb.append("1");
                    } else if (statusArr[k].equals("middle")) {
                        sb.append("2");
                    } else {
                        sb.append("3");
                    }
                }
                if (sb.length() > maxLength) {
                    maxLength = sb.length();
                }
                sb.reverse();
                people.add(new Person(name, sb.toString())); // "name:"" "status" "class"
            }
            for (Person person : people) {
                person.checkStatus(maxLength);
            }
            Collections.sort(people, pc);
            for (Person person : people) {
                pw.println(person.name);
            }
            pw.println("==============================");
        }
        pw.close();
        br.close();
    }
}

class Person {
    public String name;
    public String status;

    public Person(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public void checkStatus(int maxLength) {
        if (this.status.length() < maxLength) {
            StringBuilder sb = new StringBuilder(status);
            for (int i = 0; i < maxLength - this.status.length(); i++) {
                sb.append("2");
            }
            this.status = sb.toString();
        }
    }
}

class PeopleComparator implements Comparator<Person> {
    public PeopleComparator() {
    }

    public int compare(Person a, Person b) {
        int result = a.status.compareTo(b.status);
        if (result == 0) {
            return a.name.compareTo(b.name);
        } else {
            return result;
        }
    }
}