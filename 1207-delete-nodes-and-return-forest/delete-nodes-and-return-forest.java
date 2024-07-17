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
    
    List<TreeNode> ans = new ArrayList<>();
    boolean[]del = new boolean[1001];

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int i : to_delete) del[i] = true;
        if(get_ans(root) == false) ans.add(root);
        return ans;
    }

    public boolean get_ans(TreeNode root){
        if(root == null) return false;

        if( get_ans(root.left) == true ) root.left = null;
        if( get_ans(root.right) == true ) root.right = null;

        if( del[root.val] == true ){
            if(root.left != null ) ans.add(root.left);
            if(root.right != null ) ans.add(root.right);

            return true;
        }

        return false;
    }
}