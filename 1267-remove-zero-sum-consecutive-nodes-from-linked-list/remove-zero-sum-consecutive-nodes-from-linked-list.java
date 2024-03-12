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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode chead = new ListNode(-2000);
        chead.next = head;
        

        HashMap<Integer, ListNode> mp = new HashMap<>();
        int prefix = 0;
        ListNode ptr = chead.next;
        ListNode temp ;
        mp.put(0, chead);

        while(ptr != null){
            prefix += ptr.val;

            if(mp.containsKey( prefix )){
                ListNode start = mp.get(prefix);
                temp = start;
                int sum = prefix;
                while(temp !=ptr){
                    temp = temp.next;
                    sum += temp.val;
                    if(temp!=ptr) mp.remove(sum);;
                }
                start.next = ptr.next;               
                
            }
            else mp.put(prefix, ptr);

            ptr = ptr.next;
        }


        return chead.next;
    }
}