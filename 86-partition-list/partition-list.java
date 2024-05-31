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
    public ListNode partition(ListNode head, int x) {
        ListNode l_head = new ListNode();
        ListNode h_head = new ListNode();

        ListNode l = l_head;
        ListNode h = h_head;
        ListNode ptr = head;

        while(ptr!=null){
            if(ptr.val < x){
                l.next = ptr;
                l = l.next;
            }
            else{
                h.next = ptr;
                h = h.next;
            }

            ptr = ptr.next;
        }

        l.next = null;
        h.next = null;

        l.next = h_head.next;

        return l_head.next;
    }
}