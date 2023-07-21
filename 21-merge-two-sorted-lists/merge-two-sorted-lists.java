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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1;
        ListNode j = list2;
        ListNode head = new ListNode();
        ListNode k = head;

        while(i!= null && j!=null){
            ListNode temp = new ListNode();
            if(i.val<j.val){
                temp.val = i.val;
                i=i.next;
            }
            else{
                temp.val=j.val;
                j=j.next;
            }
            k.next=temp;
            k=temp;
        }

        if(i==null)k.next=j;
        else if(j==null)k.next=i;

        return head=head.next;
    }
}