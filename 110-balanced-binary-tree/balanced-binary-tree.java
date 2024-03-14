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
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        get_ans(root, 0);
        return ans;
    }
    public int get_ans(TreeNode root, int height){
        if(ans==false) return -1;
        if(root==null) return height;

        int l = get_ans(root.left, height+1);
        int r = get_ans(root.right, height+1);

        if(l-r > 1 ||  l-r < -1){
            ans = false;
        }

        return Math.max(l,r);
    }
}