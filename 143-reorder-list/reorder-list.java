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
    public void reorderList(ListNode head) {
        ListNode tail = head;
        Stack<ListNode> st = new Stack<>();
        while(tail!=null){
            st.add(tail);
            tail = tail.next;

        }

        reorder(head,st);
        
    }

    public void reorder(ListNode head, Stack<ListNode> st){
        if(head.next==null || head.next.next==null) return;
        ListNode tail = st.pop();

        ListNode temp = head.next;
        head.next = tail;
        tail.next = temp;

        st.peek().next=null;
        head = temp;

        reorder(head,st);
    }
}