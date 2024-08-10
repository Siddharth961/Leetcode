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
    public ListNode mergeKLists(ListNode[] lists) {
       
        int count=0;
        ListNode ans = null;


        while(count!=lists.length){
            ans = mergeTwoLists(ans,lists[count]);
            count++;
        }

        return ans;
    }

    public ListNode get_ans(int s, int e, ListNode[]lists){
        if(s==e) return lists[s];
        if(s == e-1) return mergeTwoLists( lists[s], lists[e]);

        int mid = s + (e-s)/2;

        ListNode left = get_ans(s, mid, lists);
        ListNode right = get_ans(mid+1, e, lists);

        return mergeTwoLists(left, right);
    }

     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1;
        ListNode j = list2;
        ListNode head = new ListNode();
        ListNode k = head;

        while(i!= null && j!=null){
            
            if(i.val<j.val){
                k.next=i;
                k=k.next;
                i=i.next;
            }
            else{
                k.next=j;
                k=k.next;
                j=j.next;
            }
            
        }

        if(i==null)k.next=j;
        else if(j==null)k.next=i;

        return head=head.next;
    }
}