/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode i = new ListNode();
        ListNode j = new ListNode();

        i=head;
        j=head;

        while(j!=null && j.next!=null ){
            i = i.next;
            j=j.next.next;
            if(j==i)return true;
        }

        return false;
    }
}