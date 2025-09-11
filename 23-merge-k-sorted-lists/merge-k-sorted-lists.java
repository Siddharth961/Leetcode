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
        
        ListNode chead = new ListNode();

        ListNode ptr = chead;

        PriorityQueue<ListNode> pq = new PriorityQueue<>( (a,b) -> a.val - b.val);

        for(ListNode l : lists) if(l!=null)pq.add(l);

        while(pq.size() > 0){
            ptr.next = pq.remove();

            ptr = ptr.next;

            if(ptr.next != null) pq.add(ptr.next);

            ptr.next = null;

        }

        return chead.next;
    }
}