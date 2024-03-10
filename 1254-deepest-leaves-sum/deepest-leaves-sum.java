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
    public int deepestLeavesSum(TreeNode root) {
        int[]ans = get_ans(root, 0);
        return ans[0];
    }

    public int[] get_ans(TreeNode root, int level){

        if(root.left==null && root.right==null){
            int[]arr = {root.val, level};
            return arr;
        }

        if(root.left==null) return get_ans(root.right, level+1);
        if(root.right == null) return get_ans(root.left, level+1);

        int[]left = get_ans(root.left, level+1);
        int[]right = get_ans(root.right, level+1);

        if(left[1] > right[1]) return left;
        if(left[1] < right[1]) return right;

        left[0] += right[0];

        return left;        
    }
}