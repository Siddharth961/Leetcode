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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return get_ans(root, targetSum);
    }

    public boolean get_ans(TreeNode root, int tar){
        if(root.left == null && root.right==null){
            if(tar-root.val==0) return true;
            return false;
        }

        boolean a = false;
        if(root.left != null) a = get_ans(root.left, tar-root.val);
        if(a==true) return a;

        if(root.right != null) a = get_ans(root.right, tar-root.val);

        return a;
    }
}