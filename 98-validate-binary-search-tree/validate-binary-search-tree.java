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
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean check(TreeNode root, long lowerbound, long upperbound){
        if(root == null ) return true;

        boolean curr = root.val > lowerbound && root.val < upperbound;
        boolean left = check(root.left, lowerbound, root.val);
        boolean right = check(root.right, root.val, upperbound);

        return curr && left && right;
    }
}

// on right

// curr - greater than parent less than  parents less
// left tree - greater then parent less then curr
// right tree - greater than current

