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
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        if(root == null){
            return root == null && head == null;
        }

        boolean ans = false;

        if( root.val == head.val){
            ans = check( head, root);
            System.out.println(ans);
        }

        ans = ans || isSubPath(head, root.left) || isSubPath(head, root.right);

        return ans;
    }

    public boolean check (ListNode ptr, TreeNode root){
        if( root == null || ptr == null){
            if(ptr == null) return true;
            return false;
        }

        if(root.val != ptr.val) return false;

        return check(ptr.next, root.left) || check(ptr.next, root.right);
    }
}