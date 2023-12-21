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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode chead = new ListNode();
        ListNode ptr = head;
        ListNode temp = head;
        ListNode safe = chead;

        while(ptr != null){
            if(temp.val != ptr.val){
                if(temp.next == ptr){
                    safe.next = temp;
                    safe = safe.next;
                    //safe.next = null;
                }

                temp = ptr;
            }

            
                ptr = ptr.next;
            
        }

        if(temp.next==ptr) safe.next = temp;
        else safe.next = null;

        return chead.next;
    }
}