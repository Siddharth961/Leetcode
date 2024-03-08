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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return get_ans(root, subRoot);
    }

    public boolean get_ans(TreeNode root, TreeNode subRoot){
        if(root==null) return false;

        boolean a = false;

        if(root.val == subRoot.val){
            a = check(root, subRoot); 
        }
        if(a==true) return a;

        a = a || get_ans(root.left, subRoot);
        if(a==true) return a;

        return get_ans(root.right, subRoot);
    }

    public boolean check( TreeNode root, TreeNode subRoot ){

        if( root == null && subRoot == null) return true;
        if( root == null || subRoot == null) return false;

        if(root.val != subRoot.val) return false;

        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}