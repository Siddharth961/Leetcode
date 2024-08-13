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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int ans = get_ans(root);
        if( max > ans) return max;
        return ans;
    }

    public int get_ans(TreeNode root){

        if(root == null) return 0;

        int ans = Integer.MIN_VALUE;

        int left = get_ans(root.left);
        int right = get_ans(root.right);
        int one_side = Math.max( left, right) + root.val ;

        int all = root.val + left + right;

        max = Math.max( max, all);
        max = Math.max( max, one_side);
        max = Math.max( max, root.val);

        ans = one_side;        
        ans = Math.max( ans, root.val);

        return ans; 

    }
}