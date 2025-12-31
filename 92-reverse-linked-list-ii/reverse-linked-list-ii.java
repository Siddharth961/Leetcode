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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        // ListNode chead = new ListNode();
        // chead.next = head;

        // int curr = 0;
        // ListNode ptr = chead;

        // ListNode l_prev;
        // ListNode r_next;

        // while(ptr != null){
        //     if(curr == left-1){
        //         l_prev = ptr;
        //     }

        //     if(curr == right){
        //         r_next = ptr.next;
        //         ptr.next = null;
        //         break;
        //     }

        //     curr++;
        //     ptr = ptr.next;
        // }

        // ListNode temp = l_prev.next;

        // ListNode[]rev_head_tail = reverse(temp);

        // l_prev.next = rev_head_tail[0];

        // rev_head_tail[1].next = r_next;

        // return chead.next;

        ListNode chead = new ListNode();
        chead.next = head;

        int curr = 0;
        ListNode ptr = chead;

        // IDEA - FOR ONE PASS SOLUTION
        // while travelling when we enter target range
        //     - start making a new linked list
        //     - keep travelling old one but add those elements at START of new list
        //     - when we reach RIGHT connect the new list to endpoints
        // NOTE Store left endpoint beforehand and of the tail of new list

        ListNode nhead = null;
        ListNode ntail = null;
        ListNode l_prev = null;
        ListNode temp = null;

        while(curr != left){

            if(curr == left - 1){
                l_prev = ptr;
            }

            ptr = ptr.next;
            curr++;
        }

        l_prev.next = null;

        while(curr <= right){

            temp = ptr.next;
            ptr.next = null;

            if(ntail == null){
                nhead = ptr;
                ntail = ptr;
                
            }
            else{

                ptr.next = nhead;
                nhead = ptr;                
            }

            curr++;
            ptr = temp;

        }

        l_prev.next = nhead;
        ntail.next = ptr;

        return chead.next;
    }


}