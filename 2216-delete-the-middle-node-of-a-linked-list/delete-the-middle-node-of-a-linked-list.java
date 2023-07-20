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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null)return null;
        else if(head.next.next==null){
            head.next = null;
            return head;
        }

        ListNode i = new ListNode();
        ListNode j = new ListNode();

        i=head;
        j=head;

        while(j.next.next!=null && j.next.next.next!=null){
            i = i.next;
            j = j.next.next;
        }
        i.next = i.next.next;
        return head;
    }
}