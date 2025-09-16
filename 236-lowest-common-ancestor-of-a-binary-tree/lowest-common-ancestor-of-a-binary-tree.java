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
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        travel(root, p, q);        

        return ans;
        
    }

    public boolean travel(TreeNode root, TreeNode p, TreeNode q){

        if(root == null) return false;

        boolean left = travel(root.left, p, q);
        boolean right = travel(root.right, p, q);

        boolean curr = root == p || root == q;

        if( left && right ) ans = root;

        else if( (left || right) && curr){
            
            ans = root;
        }

        return left || right || curr;
    }
}