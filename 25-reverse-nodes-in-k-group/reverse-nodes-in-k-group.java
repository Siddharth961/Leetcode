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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head.next==null) return head;



        ListNode chead = new ListNode(-1);
        chead.next = head;
        ListNode i = chead;
        ListNode j = i.next;

        

        int count = 0;

        while(j!=null){
            while(count!=k && j!=null){
                j=j.next;
                count++;
            }
            

            if(count<k && j==null) break;

            i.next = reverse(i.next,j);

            while(i.next!=null) i=i.next;

            i.next = j;
            count=0;
        }

        return chead.next;
    }

    public ListNode reverse(ListNode head,ListNode end){
        ListNode i = head;
        ListNode j = i.next;
        ListNode t = i.next.next;


        i.next=null;

        while(j.next!=end){
            j.next=i;
            i=j;
            j=t;
            t = t.next;
        }

        j.next = i;

        return j;
    }
}
