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
        ListNode ptr = head;
        int count = -1;
        while(ptr!=null){
            ptr=ptr.next;
            count++;
        }
        int s = 0;
        ptr = head;
        while(ptr!=null){
            s+=ptr.val*(Math.pow(2,count));
            count--;
            ptr=ptr.next;
        }

        return s;
    }
}