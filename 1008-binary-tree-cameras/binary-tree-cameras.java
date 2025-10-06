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
    public int minCameraCover(TreeNode root) {
        int[]ans = get_ans(root);

        if(ans[1] == 0) ans[0]++;
        return ans[0];
    }

    public int[] get_ans(TreeNode root){

        if( root == null){
            return new int[]{0, 1, 0}; // cameras used, am watched?, have camera?
        }

        int[]left = get_ans(root.left);
        int[]right = get_ans(root.right);

        int[]ans = new int[3];

        ans[0] = left[0] + right[0]; // adding cameras used

        if( left[1] == 0 || right[1] == 0){ // if either child not watched

            ans[0]++; // parent takes camera
            ans[1] = 1; // parent is watched;
            ans[2] = 1; //parent have camera

        }
        else if( left[2] == 1 || right[2] == 1){ // one of them have camera

            ans[1] = 1; // parent is watched

        }

        return ans;
    }
}

// what needs to be returned - camera used, am i watched, do i have camera

// if either child not watched, parent takes a camera
// if both child watched - parent dont take camera and sends i am not watched
// if either child have camera - parent dont take camera and sends i am watched