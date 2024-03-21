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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return get_ans(head, null);
    }

    public TreeNode get_ans(ListNode head, ListNode tail){
        if(head==null) return null;
        if(head==tail) return null;
        ListNode i = head;
        ListNode j = head;
        while(j!=tail && j.next!=tail ){
            i = i.next;
            j = j.next.next;
        }

        // System.out.println(i.val+" "+j.val);

        TreeNode root = new TreeNode(i.val);

        if(i==j) return root;
        root.left = get_ans(head, i);
        root.right = get_ans(i.next, tail);

        return root;

    }
}