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
    public String tree2str(TreeNode root) {
        return get_ans(root);
    }

    public String get_ans(TreeNode root){
        if(root==null) return "";
        if(root.left==null && root.right==null) return root.val + "";

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        String left = get_ans(root.left);
        sb.append('(');
        sb.append(left);
        sb.append(')');

        String right = get_ans(root.right);
        if(right.length()>0){
            sb.append('(');
            sb.append(right);
            sb.append(')');

        }

        return sb.toString();
    }
}