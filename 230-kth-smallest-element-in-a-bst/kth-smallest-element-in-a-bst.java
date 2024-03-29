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
    int nk = 0;
    public int kthSmallest(TreeNode root, int k) {
        nk = k;
        get_ans(root);
        return ans;
    }

    public void get_ans(TreeNode root){
        if(root == null) return ;

        get_ans(root.left);
        if(nk==0) return ;
        nk--;
        if(nk==0){
             ans = root.val;
             return ;
        }

        get_ans(root.right);
    }
}