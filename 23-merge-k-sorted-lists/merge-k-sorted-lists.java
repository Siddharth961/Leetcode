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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode ptr=head;
        ListNode min = head;
        int j=0;
        int count=0;

        boolean[]end = new boolean[k];


        while(count!=k){
            min = head;
            for(int i=0; i<k; i++){
                if(end[i]==true) continue ;
                if(lists[i]==null){
                    end[i] = true;
                    count++;
                    continue;
                }

                if(lists[i].val < min.val){
                    min = lists[i];
                    j = i;
                }
            }

            if(count==k) break;

            ptr.next = min;
            ptr = ptr.next;
            lists[j] = lists[j].next;
        }

        return head.next;
    }
}