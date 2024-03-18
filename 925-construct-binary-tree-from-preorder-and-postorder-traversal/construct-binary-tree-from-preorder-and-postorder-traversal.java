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
    int pre = 0;
    int post = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode temp = new TreeNode(preorder[pre]);
        if(preorder[pre] == postorder[post]){
            pre++;
            post++;
            return temp;
        }
        pre++;

        temp.left = constructFromPrePost(preorder, postorder);

        if(temp.val == postorder[post] ){
            post++;
            return temp;
        }

        temp.right = constructFromPrePost( preorder, postorder);

        post++;
        return temp;
    }
}