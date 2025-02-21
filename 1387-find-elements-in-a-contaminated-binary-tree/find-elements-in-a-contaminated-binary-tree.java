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
class FindElements {
    HashSet<Integer>st = new HashSet<>();


    public FindElements(TreeNode root) {
        helper(root);
    }

    public void helper(TreeNode root){
        if(root == null) return;
        if(root.val == -1) root.val = 0;

        st.add(root.val);

        if(root.left != null) root.left.val = 2 * root.val + 1;
        if(root.right != null) root.right.val = 2 * root.val + 2;

        helper(root.left);
        helper(root.right);
    }
    
    public boolean find(int target) {
        return st.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */