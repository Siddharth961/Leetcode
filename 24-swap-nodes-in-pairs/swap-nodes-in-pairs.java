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
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        ListNode i = head;

        while(i.next!=null && i.next.next!=null){
            ListNode temp = i.next;
            i.next = i.next.next;

            temp.next = i.next.next;
            i.next.next = temp;
            

            System.out.println(i.val);
            
            i = i.next.next;
        }

        return head.next;
    }
}