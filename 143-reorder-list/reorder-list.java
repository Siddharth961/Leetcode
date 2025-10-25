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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) return ;
        
        ListNode i = head;
        ListNode j = head;


        while(j.next != null && j.next.next != null){

            i = i.next;
            j = j.next.next;
        }

        ListNode head2 = i.next;

        // System.out.println(k.val);
        i.next = null;

        head2 = reverse(head2);

        ListNode k = head2;

        // while(k!=null){
        //     System.out.println(k.val);
        //     k = k.next;
        // }

        i = head;
        j = head2;

        ListNode chead = new ListNode();
        ListNode ptr = chead;
        

        while(i != null || j!= null){

            ptr.next = i;
            i = i.next;
            ptr = ptr.next;

            ptr.next = j;
            if(j != null) j = j.next;
            ptr = ptr.next;
        }


    }

    public ListNode reverse(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode i = head;
        ListNode j = head.next;
        ListNode temp;

        i.next = null;

        while( j.next != null){

            temp = j.next;
            j.next = i;

            i = j;
            j = temp;
        }

        j.next = i;

        return j;
    }
}