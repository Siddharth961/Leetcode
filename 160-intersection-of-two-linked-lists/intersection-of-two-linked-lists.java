/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode ptr1 = head1;
        ListNode ptr2 = head2;

        int size1=0;
        int size2=0;

        while(ptr1!=null){
            ptr1=ptr1.next;
            size1++;
        }

        while(ptr2!=null){
            ptr2=ptr2.next;
            size2++;
        }

        ptr1=head1;
        ptr2=head2;

        while(size1!=size2){
            if(size1>size2){
                ptr1=ptr1.next;
                size1--;
            }
            else if(size2>size1){
                ptr2=ptr2.next;
                size2--;
            }
        }

        while(ptr1!=ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
}