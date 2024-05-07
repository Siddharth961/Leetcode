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
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);

        ListNode ptr = head;
        int carry = 0;
        int val = 0;
        ListNode tail = null;

        while(ptr!=null){
            val = ptr.val*2 + carry;
            ptr.val = val%10;
            carry = val/10;
            if(ptr.next==null) tail = ptr;
            ptr =  ptr.next;
        }

        if(carry>0){
            tail.next = new ListNode(carry);
        }

        return reverse(head);
    }

    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode i = head;
        ListNode j = head.next;
        ListNode temp = head.next.next;

        i.next = null;

        while(temp!=null){
            j.next = i;
            i = j;
            j = temp;
            temp = temp.next;
        }

        j.next = i;

        // while(j!=null){
        //     System.out.print(j.val+" ");
        //     j = j.next;
        // }

        return j;

    }
}