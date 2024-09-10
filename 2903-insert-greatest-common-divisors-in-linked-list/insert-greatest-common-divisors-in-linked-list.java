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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode ptr = head;
        ListNode temp = null;

        while( ptr.next != null){

            temp = new ListNode( hcf(ptr.val, ptr.next.val ));
            temp.next = ptr.next ;
            ptr.next = temp;
            ptr = temp.next;
        }

        return head;
    }

    public int hcf(int a, int b){
        

        if(b%a == 0) return a;

        return hcf( b%a, a);
    }
}