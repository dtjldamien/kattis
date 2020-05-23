import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

public class JoinStrings {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        List<ListNode> listNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
            ListNode node = new ListNode(i);
            listNodes.add(node);
        }
        String[] operators;
        int aIdx;
        int bIdx;
        int finalIdx = 0;
        ListNode aNode;
        ListNode bNode;
        for (int i = 0; i < n - 1; i++) {
            operators = br.readLine().split(" ");
            aIdx = Integer.parseInt(operators[0]) - 1;
            bIdx = Integer.parseInt(operators[1]) - 1;
            finalIdx = aIdx;
            aNode = listNodes.get(aIdx);
            bNode = listNodes.get(bIdx);
            aNode.tail.next = bNode;
            aNode.tail = bNode.tail;
        }
        ListNode currNode = listNodes.get(finalIdx);
        while (currNode != null) {
            pw.print(strings[currNode.item]);
            currNode = currNode.next;
        }
        pw.close();
        br.close();
    }
}

class ListNode {
    public int item;
    public ListNode next;
    public ListNode head;
    public ListNode tail;

    public ListNode(int val) { 
        item = val; 
        next = null; 
        tail = this;
    }
}