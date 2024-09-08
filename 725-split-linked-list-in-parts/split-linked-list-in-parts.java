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

        ListNode ptr = head;
        int size = 0;

        while(ptr != null){
            size++;
            ptr = ptr.next;
        }

        int split = 0;

        split = size/k;
        if( size%k != 0) split++;        

        ptr = head;
        int idx = 0;
        ListNode temp = null;
        
        while(ptr != null && k>0){
            arr[idx] = ptr;

            for(int i=1; i<split; i++){
                ptr = ptr.next;
            }

            temp = ptr.next;
            ptr.next = null;
            ptr = temp;

            size = size - split;
            k--;

            if(k>0){
                split = size/k;
                if( size%k != 0) split++;
            }

            idx++;

        }

        return arr;

    }
}