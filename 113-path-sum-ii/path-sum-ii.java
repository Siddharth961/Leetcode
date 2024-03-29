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
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> al = new ArrayList<>();
        get_ans(root, targetSum, al);
        return ans;
    }

    public void get_ans(TreeNode root, int tar, List<Integer>al){
        if(root == null) return ;

        if(root.left==null && root.right==null){
            if(tar-root.val==0){
                al.add(root.val);
                ans.add( new ArrayList<>(al));
                al.remove(al.size()-1);

                return ;
            }
        }

        al.add(root.val);
        get_ans(root.left, tar-root.val, al);
        get_ans(root.right, tar-root.val, al);
        al.remove(al.size()-1);
    }
}