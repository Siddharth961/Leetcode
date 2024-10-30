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
    public int getMinimumDifference(TreeNode root) {
        int[]ans = new int[2];
        ans[0] = -1;
        ans[1] = Integer.MAX_VALUE;
        get_ans(root, ans);
        return ans[1];
    }

    public void get_ans(TreeNode root, int[]ans){
        if(root == null) return;
        get_ans(root.left, ans);

        int val = Math.abs(ans[0] - root.val);
        
        if(ans[0] != -1 && ans[1] > val) ans[1] = val;
        ans[0] = root.val;

        get_ans(root.right, ans);
    }
}