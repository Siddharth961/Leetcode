/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode i = new ListNode();
        ListNode j = new ListNode();

        i = head;
        j = head;

        boolean isCycle = false;

        while(j!=null && j.next!=null){
            i = i.next;
            j = j.next.next;
            if(i==j){
                isCycle = true;
                break;
            }
        }

        if(isCycle==false) return null;
        else{
            ListNode temp = head;
            while(i!=temp){
                i=i.next;
                temp=temp.next;
            }
            return temp;
        }

    }
}