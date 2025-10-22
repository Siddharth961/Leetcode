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

        if(head == null)return null;

        ListNode chead = new ListNode();
        ListNode ptr = chead;

        ListNode i = head;
        ListNode j = head.next;

        int prev = 200;

        while( j != null){
            
            if(i.val == j.val){
                prev = i.val;
            }

            else{
                if(i.val != prev){
                    ptr.next = i;
                    ptr = ptr.next;
                }
            }

            i = i.next;
            j = j.next;
            
        }

        if(i.val != prev){
            ptr.next = i;
            ptr = ptr.next;
        }

        ptr.next = null;

        return chead.next;
    }
}