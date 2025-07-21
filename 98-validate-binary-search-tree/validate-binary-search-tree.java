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
    public boolean isValidBST(TreeNode root) {
        return get_ans(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean get_ans(TreeNode root, long smallest, long largest){

        if( root == null ) return true;

        if( root.val <= smallest || root.val >= largest ) return false;

        boolean left = get_ans(root.left, smallest, root.val );
        boolean right = get_ans(root.right, root.val, largest );

        // System.out.println(left);
        // System.out.println(right);

        return left && right;
    }
}