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
        ListNode i = head;
        ListNode j = head;

        int size = 0;

        while(i != null){
            i = i.next;
            size++;                                                         
        }

        k = k % size;
        i = head;

        while(k>0){
            j = j.next;
            k--;

        }

        while( j.next != null){
            i = i.next;
            j = j.next;
        }

        j.next = head;
        head = i.next;
        i.next = null;

        return head;
    }
}