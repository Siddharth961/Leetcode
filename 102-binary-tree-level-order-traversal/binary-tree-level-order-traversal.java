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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(new TreeNode(-1001));

        List<Integer> al = new ArrayList<>();
        TreeNode temp ;

        while(q.size()>0){
            temp = q.remove();
            if(temp.val < -1000){
                ans.add(al);
                al = new ArrayList<>();
                if(q.size()>0)q.add(temp);
            }
            else{
                al.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }

        return ans;
        
    }
}