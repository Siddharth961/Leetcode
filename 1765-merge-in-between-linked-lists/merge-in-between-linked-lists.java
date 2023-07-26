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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0;
        ListNode j = list1;
        ListNode i = list2;

        while(i.next!=null){
            i = i.next;
        }

        while(j!=null){
            if(count==a-1){
                ListNode temp = j;
                j=j.next;
                count++;
                temp.next = list2;
            }
            else if(count==b+1){
                i.next = j;
                break;

            }

            else{
                j=j.next;
                count++;
            }
        }
        return list1;
    }
}