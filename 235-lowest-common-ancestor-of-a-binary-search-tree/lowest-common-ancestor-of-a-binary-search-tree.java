/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return get_ans(root, p, q);
    }

    public TreeNode get_ans(TreeNode root, TreeNode p, TreeNode q){
        if(root == p || root == q) return root; // one of them is root so next is below it hence ans is root

        if(p.val<root.val && q.val<root.val) return get_ans(root.left, p, q); // both must be in left subtree
        else if(p.val>root.val && q.val>root.val) return get_ans(root.right, p, q); //both must be in right subtree
        else return root; // they got seperated here so root is Last common ancestor
    }
}