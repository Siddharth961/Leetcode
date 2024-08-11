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
    public class Pair implements Comparable<Pair>{
        ListNode node;
        int val;

        Pair(ListNode p){
            node = p;
            val = p.val;
        }

        @Override
        public int compareTo( Pair p2 ){
            return this.val - p2.val;
        }

    }
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0) return null;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<lists.length; i++){
            
            if(lists[i]!=null) pq.add( new Pair(lists[i]) );
        }

        ListNode chead = new ListNode();
        ListNode ptr = chead;

        while(pq.size()>0){
            Pair p = pq.poll();
            ptr.next = p.node;
            ptr = ptr.next;

            if( p.node.next != null) pq.add(new Pair( p.node.next));
        }

        return chead.next;
    }
}