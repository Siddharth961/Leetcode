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
    public TreeNode deleteNode(TreeNode root, int key) {
        return get_ans(root, key);
    }

    public TreeNode get_ans(TreeNode root, int key){
        if(root == null) return null;

        if(root.val==key){
            if(root.left==null && root.right==null) return null;
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;

            TreeNode newRoot = leftmost(root.right);
            root.val = newRoot.val;
            root.right = get_ans(root.right, newRoot.val);
        }

        if(key<root.val){
            root.left = get_ans(root.left, key);
        }
        else if(key>root.val){
            root.right = get_ans(root.right, key);
        }

        return root;

        
    }

    public TreeNode leftmost(TreeNode root){
        if(root.left==null) return root;
        

        return leftmost(root.left);
    }
}