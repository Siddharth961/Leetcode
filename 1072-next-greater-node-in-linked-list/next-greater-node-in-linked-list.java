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
        ListNode ptr = head;

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();

        while(ptr!=null){
            al.add(ptr.val);
            ptr = ptr.next;
        }

        int[]arr = new int[al.size()];
       
       for(int i=al.size()-1; i>=0 ; i--){

           while(st.size()!=0 && al.get(st.peek())<= al.get(i)){
               st.pop();
            }

           if(st.size()==0) arr[i] = 0;
           else arr[i] = al.get(st.peek());
           st.push(i);
       }
       

        

        return arr;
    }
}