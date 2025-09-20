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
    int ans = 0;
    HashMap<Integer, Integer> mp;
    public int widthOfBinaryTree(TreeNode root) {
        mp = new HashMap<>();

        travel(0, 0, root);

        return ans;
    }

    public void travel(int idx, int level, TreeNode root){

        if(root == null) return ;

        if( !mp.containsKey(level) ){
            mp.put(level, idx);
            ans = Math.max(ans, 1);
        } 
        else{

            ans = Math.max( ans, Math.abs(mp.get(level) - idx) + 1);

            mp.put(level, Math.min(mp.get(level), idx) );
        }

        travel(2*idx + 1, level+1, root.left );
        travel(2*idx + 2, level+1, root.right );

    }
}