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
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        get_ans(root, ' ');
        return ans;
    }

    public void get_ans( TreeNode root, char ch){
        if(root == null) return ;
        if(root.left==null && root.right==null){
            if(ch == 'l') ans += root.val;
            return ;
        }

        get_ans(root.left, 'l');
        get_ans(root.right, 'r');
    }
}