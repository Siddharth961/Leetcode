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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> st = new HashSet<>();

        for(int i : nums) st.add(i);

        ListNode chead = new ListNode();
        ListNode ptr = chead;

        ListNode i = head;

        while(i != null){
            if( !st.contains(i.val)){
                ptr.next = i;
                ptr = ptr.next;
            }

            i = i.next;
        }

        ptr.next = null;

        return chead.next;
    }
}