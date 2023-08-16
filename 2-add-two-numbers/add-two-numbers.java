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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> num1 = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();

        ListNode i = l1;
        while(i!=null){
            num1.add(i.val);
            i=i.next;
        }

        i=l2;
        while(i!=null){
            num2.add(i.val);
            i=i.next;
        }

        

       
        ListNode head = new ListNode(-1);
        i = head;

        int a = 0;
        int b = 0;

        int c=0,val=0;

        while(a<num1.size() || b<num2.size() || c>0){
            val =  c;
            if(a<num1.size()) val += num1.get(a);
            if(b<num2.size()) val += num2.get(b);
            c = val/10;
            val = val%10;
            ListNode temp = new ListNode(val);

            i.next = temp;
            i = temp;

            a++;
            b++;

        }


        return head.next;
    }
    }
