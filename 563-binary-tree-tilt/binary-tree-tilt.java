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
    public int findTilt(TreeNode root) {
        int[]ans = new int[1];
        get_ans(root, ans);
        return ans[0];
    }

    public int get_ans(TreeNode root, int[]ans){
        if(root == null) return 0;

        int left = get_ans(root.left, ans);
        int right = get_ans(root.right, ans);

        ans[0] += Math.abs(left - right);

        return left + right + root.val;
    }
}