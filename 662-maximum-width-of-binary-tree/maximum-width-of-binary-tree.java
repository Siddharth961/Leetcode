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
    public class Node{
        TreeNode root;
        int level;
        Node(TreeNode root, int level){
            this.root = root;
            this.level = level;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<Node> q = new LinkedList<>();

        q.add( new Node(root, 0));
        int max = 0;

        while(q.size()>0){
            int n = q.size();
            max = Math.max( max, q.getLast().level - q.getFirst().level + 1);

            while(n>0){
                Node temp = q.removeFirst();

                if(temp.root.left != null) q.add(new Node(temp.root.left, 2*temp.level));
                if(temp.root.right != null) q.add(new Node(temp.root.right, 2*temp.level + 1));

                n--;
            }

        }
        return max;
    }
}