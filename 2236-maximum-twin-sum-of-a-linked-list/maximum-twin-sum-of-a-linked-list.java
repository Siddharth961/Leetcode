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
    public int pairSum(ListNode head) {

        Stack<Integer> st = new Stack<>();

        ListNode ptr = head;
        int size = 0;

        while(ptr != null){
            st.push(ptr.val);
            size++;

            ptr = ptr.next;
        }

        ptr = head;
        int ans = 0;

        while(st.size() > size/2){

            ans = Math.max(ans, ptr.val + st.pop() );
            ptr = ptr.next;
        }

        return ans;        
    }
}