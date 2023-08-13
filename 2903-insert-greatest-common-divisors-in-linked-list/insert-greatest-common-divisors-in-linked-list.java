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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode i = head;

        while(i.next!=null){
            int val = gcd(i.val, i.next.val);
            ListNode temp = new ListNode(val);
            temp.next = i.next;
            i.next = temp;
            i = i.next.next;
        }

        return head;
    }

    public static int gcd(int a,int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}