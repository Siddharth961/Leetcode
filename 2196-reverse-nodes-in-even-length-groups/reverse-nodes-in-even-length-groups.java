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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int group = 2;
        ListNode ptr = head;

        ListNode start;
        ListNode end;
        int n=0;

        while(ptr.next!=null){

            start = ptr;

            n = 0;
            while(ptr.next!= null && n<group){
                ptr = ptr.next;
                n++;
            }
            

            if(n%2==0){
                ListNode nstart = start.next;
                ListNode temp = rev(start.next, ptr.next);
                start.next = temp;
                ptr = nstart;
            }

            group++;

        }
        
        return head;
    }
    
    public ListNode rev(ListNode head, ListNode limit){

       
        ListNode i = head;
        if(i==limit || i==null) return head;
        ListNode j = i.next;
        ListNode temp;
        i.next = null;

        while(j!=limit){
            temp = j.next;
            j.next = i;
            i = j;
            j = temp;
        }

        head.next = limit;

        return i;
    }
}