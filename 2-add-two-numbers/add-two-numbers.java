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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        

        

       
        ListNode head = new ListNode(-1);
        ListNode i = head;

        ListNode a = l1;
        ListNode b = l2;

        int c=0,val=0;

        while(a!=null || b!=null || c>0){
            val =  c;
            if(a!=null){
                val += a.val;
                a = a.next;
                }
            if(b!=null){
                val += b.val;
                b=b.next;
            }
            c = val/10;
            val = val%10;
            ListNode temp = new ListNode(val);

            i.next = temp;
            i = temp;


        }


        return head.next;
    }
    }
