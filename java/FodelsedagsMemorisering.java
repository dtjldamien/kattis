// https://open.kattis.com/problems/fodelsedagsmemorisering
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class FodelsedagsMemorisering {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Friend> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] friendInfo = br.readLine().split(" ");
            if (map.containsKey(friendInfo[2])) {
                Friend another = map.get(friendInfo[2]);
                if (Integer.parseInt(friendInfo[1]) < another.like) {
                    continue;
                }
            }
            map.put(friendInfo[2], new Friend(friendInfo[0], Integer.parseInt(friendInfo[1]), friendInfo[2]));
        }
        List<Friend> friends = new ArrayList<Friend>(map.values());
        Comparator<Friend> nameComparator = new Comparator<Friend>() {
            @Override
            public int compare(Friend a, Friend b) {
                return a.name.compareTo(b.name);
            }
        };
        Collections.sort(friends, nameComparator);
        pw.println(friends.size());
        for (Friend friend : friends) {
            pw.println(friend.name);
        }
        pw.close();
        br.close();
    }
}

class Friend {
    String name;
    int like;
    int day;
    int month;

    public Friend(String name, int like, String birthday) {
        this.name = name;
        this.like = like;
        String[] date = birthday.split("/");
        this.day = Integer.parseInt(date[0]);
        this.month = Integer.parseInt(date[1]);
    }
}
