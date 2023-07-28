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
    public ListNode removeNodes(ListNode head) {
        ListNode j = reverse(head);
        ListNode chead = new ListNode();
        ListNode i = chead;
        int max = j.val;
        while(j!=null){
            if(j.val>=max){
                i.next = j;
                i = i.next;
                max = j.val;
            }
            j = j.next;
        }
        i.next = null;

        return reverse(chead.next);
    }

    public ListNode reverse(ListNode head){
        if(head==null)return null;
        else if(head.next==null)return head;
        

        ListNode i = head;
        ListNode j = head.next;
        ListNode t = head.next.next;
        i.next = null;
        while(t!=null){
            j.next = i;
            i=j;
            j=t;
            t=t.next;
        }
        j.next=i;
        return j;
    }
}