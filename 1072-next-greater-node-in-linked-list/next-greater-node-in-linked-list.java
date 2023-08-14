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
    public int[] nextLargerNodes(ListNode head) {
        ListNode i = head;
        int idx = 0;

        Stack<Integer> st = new Stack<>();

        while(i!=null){
            i=i.next;
            idx++;
        }

        int[]arr = new int[idx];
        idx=0;
        i=head;

        while(i!=null){
            while(st.size()!=0 && arr[st.peek()] < i.val ){
                arr[st.peek()]=i.val;
                st.pop();
            }

            arr[idx] = i.val;
            st.push(idx);

            i=i.next;
            idx++;
        }

        while(st.size()!=0){
            arr[st.peek()]=0;
            st.pop();
        }

        return arr;
    }
}