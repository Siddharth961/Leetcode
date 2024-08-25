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
    List<Integer> al = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return al;
        get_ans(root);
        return al;
    }

    public void get_ans(TreeNode root){
        
        if(root.left != null) get_ans(root.left);
        if(root.right != null) get_ans(root.right);
        al.add(root.val);
    }
}