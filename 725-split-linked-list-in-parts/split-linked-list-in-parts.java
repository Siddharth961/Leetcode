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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[]arr = new ListNode[k];
        int n=0;
        ListNode ptr = head;
        while(ptr!=null){
            n++;
            ptr = ptr.next;
        }


        ptr=head;
        ListNode temp = null;

        int count=0;
        int i=0;

        while(ptr!=null){
            
            arr[i] = ptr;
            count = 0;
            while(count<(n/k)-1){
                ptr = ptr.next;
                count++;
            }

            if(i<(n%k) && n/k>0) ptr = ptr.next;

            temp = ptr.next;
            ptr.next=null;
            ptr = temp;
            
            i++;
        }

        return arr;
    }
}