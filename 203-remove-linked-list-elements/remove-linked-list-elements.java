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

        while(j!=null){
            if(j.val==val){
                i.next=j.next;
                j = j.next;

            }
            else{
                i=j;
                j = j.next;
            }
        }
        
        if(head.val == val)head=head.next;
        return head;
    }
}