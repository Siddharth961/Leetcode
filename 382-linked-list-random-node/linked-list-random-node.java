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
    int size=0;
    ListNode head;

    public Solution(ListNode head) {
        this.head = head;
        ListNode i = head;
        while(i!=null){
            i=i.next;
            size++;
        }
    }
    
    public int getRandom() {

        int n = (int)Math.floor(Math.random()*size);

        int count = 0;
        ListNode i = head;
        while(count!=n){
            i=i.next;
            count++;
        }

        return i.val;
        

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */