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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add( new TreeNode(-200));
        int level = 1;
        TreeNode temp ;

        while(q.size()>1){
            
            temp = q.remove();
            if(temp.val==-200){
                if(level==depth-1) break;
                q.add(temp);
                level++;
                continue;
            }

            if(level == depth-1){
                TreeNode t = temp.left;
                temp.left = new TreeNode(val, t, null);
                temp.right = new TreeNode(val, null, temp.right);
            }
            else{
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }

        return root;
    }
}