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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null)return null;

        ListNode ptr = head;
        ListNode temp = head;

        while(ptr!=null){
            if(ptr.val!=temp.val){
                temp.next = ptr;
                temp = temp.next;
            }
            ptr = ptr.next;
        }

        temp.next=null;
        return head;

    }
}