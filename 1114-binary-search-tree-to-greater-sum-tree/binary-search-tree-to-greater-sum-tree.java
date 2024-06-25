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
    public TreeNode bstToGst(TreeNode root) {
        get_ans(root, 0);
        return root;
    }

    public int get_ans(TreeNode root, int sum){

        if(root == null) return 0;

        int right = get_ans(root.right, sum);

        root.val += sum > right ? sum : right;

        int left = get_ans(root.left, root.val);

        return  root.val > left ? root.val : left;
    }
}