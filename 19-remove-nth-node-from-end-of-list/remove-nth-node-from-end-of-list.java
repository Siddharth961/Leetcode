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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode ptr = head;
        while(ptr.next!=null){
            size++;
            ptr = ptr.next;
        }

        if(size==1){
            head=null;
            return head;
        }

        ptr=head;
        int target = size-n;
        for(int i=0; i<target-1; i++){
            ptr = ptr.next;
        }

        if(n==size) head = head.next;

        else ptr.next = ptr.next.next;

        return head;


    }
}