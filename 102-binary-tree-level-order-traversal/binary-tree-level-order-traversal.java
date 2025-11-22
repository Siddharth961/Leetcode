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
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();

        if(root != null) q.add(root);

        while(q.size() > 0){
            int size = q.size();

            List<Integer> list = new LinkedList<>();

            while(size > 0){

                TreeNode p = q.remove();
                list.add(p.val);

                if( p.left != null) q.add(p.left);
                if( p.right != null) q.add(p.right);

                size--;

            }

            ans.add(list);
        }

        return ans;
    }
}