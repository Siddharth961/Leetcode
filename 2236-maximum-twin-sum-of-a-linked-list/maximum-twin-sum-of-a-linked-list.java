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
    public int pairSum(ListNode head) {

        if(head.next.next==null) return head.val + head.next.val;
        
        ListNode i = head;
        ListNode j = head;

        while(j!=null&& j.next!=null){
            i = i.next;
            j = j.next.next;
        }

        j = i.next;
        i.next = null;
        ListNode temp = j.next;

        while(temp!=null){
            j.next = i;
            i = j;
            j = temp;
            temp = temp.next;
        }

        j.next = i;

        i = head;

        int max = -1;
        System.out.print(i.val + " " + j.val);

        while(j!=null){
            if((i.val+j.val)>max)max = i.val+j.val;
            i = i.next;
            j = j.next;
        }
        return max;
    }
}