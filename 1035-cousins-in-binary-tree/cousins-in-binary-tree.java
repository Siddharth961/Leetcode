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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] ans = new int[4];
        get_ans(root, x, y, 0, ans);

        if(ans[0] == ans[1]) return false;

        if(ans[2] == ans[3]) return true;

        return false;

    }

    public void get_ans(TreeNode root, int x, int y, int depth, int[]arr){
        if(root == null) return ;

        if(root.val == x) arr[2] = depth;
        if(root.val == y) arr[3] = depth;
        
        if(root.left != null && root.left.val == x) arr[0] = root.val;
        if(root.left != null && root.left.val == y) arr[1] = root.val;

        if(root.right != null && root.right.val == x) arr[0] = root.val;
        if(root.right != null && root.right.val == y) arr[1] = root.val;

        get_ans(root.left, x, y, depth+1, arr);
        get_ans(root.right, x, y, depth+1, arr);
    }
}