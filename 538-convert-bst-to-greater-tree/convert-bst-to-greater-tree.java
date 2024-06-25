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
    public TreeNode convertBST(TreeNode root) {
        get_ans(root);
        return root;
    }

    // public int get_ans(TreeNode root, int sum){

    //     if(root == null) return 0;

    //     int right = get_ans(root.right, sum);

    //     root.val += sum > right ? sum : right;

    //     int left = get_ans(root.left, root.val);

    //     return  root.val > left ? root.val : left;
    // }


    int sum = 0;
    public void get_ans(TreeNode root){

        if(root == null) return ;

        get_ans(root.right);

        root.val += sum;
        sum = root.val;

        get_ans(root.left);

        
    }
}