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
    int length = 0;
    int ans = 0;
    public int findBottomLeftValue(TreeNode root) {

        get_ans(root, 0, ' ', -1);
        return ans;
        
    }

    public void get_ans(TreeNode root,int len, char child, int prev){
        if(root==null){
            if(child== 'l'){
                if(len>length){
                    length = len;
                    ans = prev;
                }
            }
            return ;
        }

        get_ans(root.left, len+1, 'l', root.val);
        get_ans(root.right, len+1, 'r', root.val);
    }
}