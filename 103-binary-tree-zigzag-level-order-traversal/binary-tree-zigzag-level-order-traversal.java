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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();        
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeNode temp = new TreeNode();

        boolean dir = true; // left to right

        int size  = 1;
        q.add(root);


        while(q.size() > 0){
            List<Integer> al = new ArrayList<>();
            size = q.size();
            while(size > 0){

                temp = q.peek();
                q.poll();

                if(temp.left != null){
                    q.add( temp.left );                    
                }
                if(temp.right != null){
                    q.add( temp.right );                    
                }
                al.add(temp.val);

                size--;
            }
        
            if(dir==true){
                ans.add(al);
                dir = false;
            }
            else{
                Collections.reverse(al);
                ans.add( al );
                dir = true;
            }            
            
        }   
        return ans;     
    }
}