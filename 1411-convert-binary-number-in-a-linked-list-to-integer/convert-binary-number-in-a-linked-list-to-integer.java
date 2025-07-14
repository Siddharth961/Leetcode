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
    public int getDecimalValue(ListNode head) {
        int size = 0;

        ListNode ptr = head;

        while(ptr != null){
            size++;
            ptr = ptr.next;
        }

        int val = 0;
        int pow =(int) Math.pow(2, size-1);
        ptr = head;

        while(ptr != null){
            val += ptr.val*pow;
            pow /= 2;
            ptr = ptr.next;
        }

        return val;
    }
}