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
    public boolean isPalindrome(ListNode head) {

        if(head.next==null)return true;
        else if (head.next.next==null){
            if(head.val == head.next.val) return true;
            else return false;
        }


        ListNode i = head;
        ListNode j = head;

        while(j!=null&&j.next!=null){
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

        while(i!=j && j.next!=null){
            if(i.val!=j.val)return false;
            i = i.next;
            j = j.next;
        }

        if(i.val != j.val) return false;
        else return true;
    }
}