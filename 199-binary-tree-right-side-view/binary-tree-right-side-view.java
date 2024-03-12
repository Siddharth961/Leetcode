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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return al;
        q.add(root);
        TreeNode temp;
        while(q.size()>0){
            int n = q.size();
            while(n>0){
                if(n==1) al.add(q.peek().val);
                temp = q.remove();
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                n--;
            }
              
        }

        return al;
    }
} 