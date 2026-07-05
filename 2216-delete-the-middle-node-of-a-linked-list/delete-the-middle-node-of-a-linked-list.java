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
        if(head.next == null) return null;
        ListNode i = head;
        ListNode j = head;

        while(j.next.next != null && j.next.next.next != null){
            i = i.next;
            j = j.next.next;
        }


        i.next = i.next.next;
        return head;
    }
}