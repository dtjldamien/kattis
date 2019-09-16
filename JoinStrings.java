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
            aNode.tail.setNext(bNode);
            aNode.tail = bNode.tail;
        }
        ListNode currNode = listNodes.get(finalIdx);
        while (currNode != null) {
            pw.print(strings[currNode.item]);
            currNode = currNode.getNext();
        }
        pw.close();
        br.close();
    }
}

class ListNode {
    /* attributes */
    public int item;
    public ListNode next;
    public ListNode tail;

    /* constructors */
    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode n) { 
        item = val; 
        next = n; 
        tail = this;
    }

    /* get the next ListNode */
    public ListNode getNext() { return next; }

    /* get the item of the ListNode */
    public int getItem() { return item; }

  /* set the item of the ListNode */
  public void setItem(int val) { item = val; }

    /* set the next reference */
    public void setNext(ListNode n) {
        next = n;
        tail = n;
    }
}