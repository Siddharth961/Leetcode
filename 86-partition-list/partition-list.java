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
        
        ListNode chead1 = new ListNode();
        ListNode chead2 = new ListNode();

        ListNode less = chead1;
        ListNode more = chead2;


        ListNode ptr = head;

        while(ptr != null){

            if(ptr.val < x){
                less.next = ptr;
                less = less.next;
            }
            else{
                 more.next = ptr;
                 more = more.next;
                 
            }

            ptr = ptr.next;
        }

        less.next = chead2.next;
        more.next = null;

        return chead1.next;
    }
}