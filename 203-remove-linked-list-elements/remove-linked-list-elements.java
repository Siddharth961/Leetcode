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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode i = head;
        ListNode j = head;

        while(j.next!=null){
            if(j.next.val==val){
                j.next = j.next.next;               

            }
            else{
                j = j.next;
            }
        }
        
        if(head.val == val)head=head.next;
        return head;
    }
}