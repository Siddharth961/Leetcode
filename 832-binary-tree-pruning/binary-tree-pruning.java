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
    public TreeNode pruneTree(TreeNode root) {
        boolean a = get_ans(root);
        if(a == false) return null;
        return root;
    }

    public boolean get_ans(TreeNode root){
        if(root == null) return false;

        boolean a  = get_ans(root.left);
        if(a == false) root.left = null;
        boolean b = get_ans(root.right);
        if(b == false) root.right = null;

        if(root.val == 1) return true;
        return a || b;
    }
}