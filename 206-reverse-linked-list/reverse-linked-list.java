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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)return head;

        ListNode i = head;
        ListNode j = head.next;
        ListNode temp = j.next;

        head.next=null;

        while(temp!=null){
            j.next = i;
            i=j;
            j=temp;
            temp=j.next;
        }

        j.next = i;

        head = j;
        return head;

    }
}