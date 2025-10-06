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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode chead = new ListNode();
        chead.next = head;

        ListNode a = chead;
        ListNode b = chead.next;
        // ListNode c = chead.next.next;

        while(b != null && b.next != null){

            a.next = b.next;

            b.next = b.next.next;

            a.next.next = b;

            a = b;
            b = b.next;
            
        }

        return chead.next;
    }
}