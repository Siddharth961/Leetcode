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
    public ListNode middleNode(ListNode head) {
        ListNode i = head;
        ListNode j = head.next;

        while(j!=null){
            i = i.next;
            j = j.next;
            if(j==null) return i;
            j = j.next;
        }

        return i;
    }
}