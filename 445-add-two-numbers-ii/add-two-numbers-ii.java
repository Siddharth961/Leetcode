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

        

       
        i = null;

        int a = num1.size()-1;
        int b = num2.size()-1;

        int c=0,val=0;

        while(a>=0 || b>=0 || c>0){
            val =  c;
            if(a>=0) val += num1.get(a);
            if(b>=0) val += num2.get(b);
            c = val/10;
            val = val%10;
            ListNode temp = new ListNode(val);

            temp.next = i;
            i=temp;

            a--;
            b--;

        }


        return i;
    }
}