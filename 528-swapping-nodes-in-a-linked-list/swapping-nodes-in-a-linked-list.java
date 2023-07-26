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
    public ListNode swapNodes(ListNode head, int k) {
        int count = 1;
        ListNode i = new ListNode();
        ListNode j = head;
        ListNode temp = new ListNode();
        while(j!=null){
            if(count==k){
                i = j;
                temp = head;
            }
            if(j.next==null){
                int t = i.val;
                i.val = temp.val;
                temp.val = t;
            }

            j=j.next;
            count++;
            if(temp.next!=null)temp = temp.next;
        }

        return head;
    }
}