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
    int global_ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int ans = 0;
        if(root.right != null) ans += get_len( root.right) ;
        if(root.left != null) ans += get_len( root.left);
        
        return Math.max(global_ans, ans);
    }

    public int get_len( TreeNode root){

        int x = 0;
        int y = 0;
        if(root.right != null) x = get_len(root.right);
        if(root.left != null) y = get_len(root.left);

        global_ans = Math.max( global_ans, x+y);

        return Math.max(x , y) + 1;
    }
}