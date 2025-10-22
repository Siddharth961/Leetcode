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
    TreeNode prev;
    TreeNode[]arr = new TreeNode[2];
    public void recoverTree(TreeNode root) {

        travel(root);


        int temp = arr[0].val;
        arr[0].val = arr[1].val;
        arr[1].val = temp;
    }

    public void travel(TreeNode root){
        if(root == null) return;

        travel(root.left);

        if(prev != null && prev.val > root.val){

            if(arr[0] == null){
                arr[0] = prev;
            }
            arr[1] = root;
        }

        prev = root;

        travel(root.right);
    }
}