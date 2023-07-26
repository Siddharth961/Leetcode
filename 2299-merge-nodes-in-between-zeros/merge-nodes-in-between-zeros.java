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
    public ListNode mergeNodes(ListNode head) {
        ListNode chead = new ListNode();
        ListNode i = chead;
        ListNode j = head.next;
        int sum = 0;

        while(j!=null){
            if(j.val!=0) sum += j.val;
            else{
                ListNode temp = new ListNode(sum);
                i.next = temp;
                i = i.next;
                sum = 0;

            }
            j=j.next;
        }

        return chead.next;


       
    }
}