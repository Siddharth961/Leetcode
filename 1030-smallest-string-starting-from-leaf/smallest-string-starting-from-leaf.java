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
    StringBuilder sb = new StringBuilder();
    String ans = "";
    
    public String smallestFromLeaf(TreeNode root) {
        get_ans(root);
        return ans;
    }

    public void get_ans(TreeNode root){

        if(root==null) return;

        char c = (char)(root.val + 'a');

        if(root.left==null && root.right==null){

            sb.append(c);

            StringBuilder temp = new StringBuilder(sb.toString());

            String a = temp.reverse().toString();
            
            if(ans.length()==0) ans = a;
            else ans = (ans.compareTo(a)<=0) ? ans : a;

            sb.deleteCharAt(sb.length()-1);
            return;
        }


        sb.append(c);
        get_ans(root.left);
        get_ans(root.right);
        sb.deleteCharAt(sb.length()-1);
    }
}