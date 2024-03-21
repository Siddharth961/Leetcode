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
    public TreeNode bstFromPreorder(int[] preorder) {
        return get_ans(preorder, 0, preorder.length-1);
    }

    public TreeNode get_ans(int[]preorder, int start, int end){
        if(start>end) return null;

        TreeNode root = new TreeNode(preorder[start]);
        
        int i=0;

        for(i=start; i<=end; i++){
            if(preorder[i]>root.val) break;
        }

        root.left = get_ans(preorder, start+1, i-1);
        root.right = get_ans(preorder, i, end);

        return root;
    }
}