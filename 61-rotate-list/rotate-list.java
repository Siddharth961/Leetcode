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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null) return head;
        
        // we need size to get correct k value
        // while doing so we will also store the tail of current list

        ListNode ptr = head;
        int size = 0;
        ListNode tail = null;

        while(ptr != null){
            size++;
            if(ptr.next == null){
                tail = ptr;
            }
            ptr = ptr.next;

        }

        k = k % size;

        if(k == 0) return head;

        ListNode i = head;
        ListNode j = head;

        while(k > 0){
            j = j.next;
            k--;
        }


        while(j.next != null){
            i = i.next;
            j = j.next;
        }
        // System.out.println(i.val + " " + j.val);

        ListNode nhead = i.next;
        i.next = null;
        tail.next = head;

        return nhead;
    }
}