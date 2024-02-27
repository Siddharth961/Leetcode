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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        travel(root, sb);
        return ans;
        
    }

    public void travel( TreeNode root, StringBuilder sb ){

        sb.append(root.val);

        if(root.right==null && root.left==null) calc(sb);

        if(root.right != null){
            travel(root.right, sb);
        }

        if(root.left != null){
            travel(root.left, sb);
        }

        sb.deleteCharAt(sb.length()-1);
    }

    public void calc (StringBuilder sb){
        if(sb.length()==0) return;


        int x = sb.charAt(0) - '0';
        // System.out.print(sb +"---------");
        // System.out.print(x+" ");


        for(int i = 1; i<sb.length(); i++){
            x = x*10 + (sb.charAt(i) - '0');
        // System.out.print(x+" ");
        }
        
        // System.out.println();

        ans += x;
    }
}