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
    int max = 0;
    int ans = 0;
    public int deepestLeavesSum(TreeNode root) {
        get_ans(root, 0);
        return ans;
    }

    public void get_ans(TreeNode root, int level){

        if(root == null) return;

        if(root.left==null && root.right==null){
            if(max < level){
                max = level;
                ans = root.val;
            }
            else if( max == level) ans += root.val;

            return;
        }


        get_ans(root.left, level+1);
        get_ans(root.right, level+1);


        return ;        
    }
}