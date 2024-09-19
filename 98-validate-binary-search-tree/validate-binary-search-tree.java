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
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        get_ans(root);
        return ans;
    }

    public int[] get_ans(TreeNode root){
        if(root == null) return null;

        if( root.left == null && root.right==null){
            int[]arr = {root.val, root.val};
            return arr;
        }

        int[]left = get_ans(root.left);
        if(ans == false) return left;
        int[]right = get_ans(root.right);


        if(left != null){
            if( root.val <= left[0] || root.val <= left[1]){
                ans = false;
                return left;
            }
        }

        if(right != null){
            if( root.val >= right[0] || root.val >= right[1]){
                ans = false;
                return right;
            }
        }

        if(left != null && right!=null){
            left[1] = right[1];
            
        }

        else if(right == null){
            left[1] = root.val;
        }

        else if(left == null){
            right[0] = root.val;
            return right;
        }

        return left;

    }
}