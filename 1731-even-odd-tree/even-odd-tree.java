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
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val%2 == 0) return false;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        TreeNode minus = new TreeNode(-1);
        q.add(minus);

        int level = 1;
        int last_val = Integer.MAX_VALUE;
        TreeNode temp;

        while(q.size()>1){

            // System.out.println(q);

            if(q.peek().val==-1){
                level++;
                if(level % 2 == 0 ) last_val = -1;
                else last_val = Integer.MAX_VALUE;
                q.remove();
                q.add(minus);
            }

            while(q.peek().val != -1){
                temp = q.peek();


                if( level % 2 == 0){
                    if(temp.left != null){
            // System.out.println((temp.left.val % 2 == 0) +" "+ (last_val>= temp.left.val));
                        if(temp.left.val % 2 == 0 || last_val>= temp.left.val) return false;
                        last_val = temp.left.val;
                         q.add(temp.left);
                    }

                    if(temp.right != null){
                        if(temp.right.val % 2 == 0 || last_val>= temp.right.val) return false;
                        last_val = temp.right.val;
                         q.add(temp.right);
                    }

                    q.remove();
                }

                if( level % 2 != 0){
                    if(temp.left != null){
                        if(temp.left.val % 2 != 0 || last_val<= temp.left.val) return false;
                        last_val = temp.left.val;
                         q.add(temp.left);
                    }

                    if(temp.right != null){
                        if(temp.right.val % 2 != 0 || last_val<= temp.right.val) return false;
                        last_val = temp.right.val;
                        q.add(temp.right);
                    }

                    q.remove();
                }
            }

            // q.add(minus);
        }

        return true;
    }
}