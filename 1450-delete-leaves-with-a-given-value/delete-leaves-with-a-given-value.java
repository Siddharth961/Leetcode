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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        char a = get_ans(root, target);
        if(a=='r') return null;
        return root;
    }

    public char get_ans(TreeNode root, int tar){

        if(root == null) return 'n'; // n means nothing


        char left = get_ans(root.left, tar);
        char right = get_ans(root.right, tar);

        if(left=='r') root.left = null;
        if(right=='r') root.right = null;

        if(root.left==null && root.right==null && root.val==tar){
            return 'r'; // r means remove
        }

        return 'n';
    }
}