/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode chead = new ListNode();

        chead.next = head;

        travel(chead, n);
        return chead.next;
    }

    public int travel(ListNode head, int n){

        if(head == null) return n;

        int i = travel(head.next, n);

        if(i == 0) head.next = head.next.next;

        return i-1;
    }
}