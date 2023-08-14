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
        ArrayList<Integer> al = new ArrayList<>();

        while(i!=null){
            while(st.size()!=0 && al.get(st.peek()) < i.val ){
                al.set(st.peek(), i.val);
                st.pop();
            }

            al.add(i.val);
            st.push(idx);

            i=i.next;
            idx++;
        }

        while(st.size()!=0){
            al.set(st.peek(),0);
            st.pop();
        }

        int[] arr = al.stream().mapToInt(j -> j).toArray();

        return arr;
    }
}