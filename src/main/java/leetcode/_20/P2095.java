package leetcode._20;


import java.util.ArrayList;

public class P2095 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode sentinel = new ListNode();
        ArrayList<Integer> a = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) {
            a.add(p.val);
        }
        ListNode tail = sentinel;
        for (int i=0;i<a.size();++i) {
            if (i != a.size() / 2) {
                tail.next = new ListNode(a.get(i));
                tail = tail.next;
            }
        }
        return sentinel.next;
    }
}
