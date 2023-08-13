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
        int min = Math.min(a,b);

        if(a==b)return a;
        else if(min!=a && a%min==0) return min;
        else if(min!=b && b%min==0) return min;

        int gcd = 0;

        for(int i=1; i<min; i++){
            
            if(a%i==0 && b%i==0) gcd = i;

        }

        return gcd;
    }
}