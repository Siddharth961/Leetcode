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
    public ListNode oddEvenList(ListNode head) {

        if(head==null)return null;

        ListNode Ohead = new ListNode();        
        ListNode Ehead = new ListNode();   

        ListNode i = Ohead;
        ListNode j = Ehead;
        ListNode k = head;

        int count=1;

        while(k!=null){
            if(count%2 != 0){
                i.next = k;
                i = i.next;
            }

            else{
                j.next = k;
                j = j.next;
            }

            k = k.next;
            count++;
        }

        Ohead = Ohead.next;
        Ehead = Ehead.next;

        j.next = null;
        i.next = Ehead;

        return Ohead;     
    }
}