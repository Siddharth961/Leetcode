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
class BSTIterator {

    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        st.push(root);
        TreeNode ptr = root;

        while(ptr.left != null){

            st.push(ptr.left);
            ptr = ptr.left;
        }
    }
    
    public int next() {
        int ans = st.peek().val;
        TreeNode temp = st.pop().right;

        while(temp != null){
            st.push(temp);
            temp = temp.left;
        }

        return ans;
    }
    
    public boolean hasNext() {
        return st.size() != 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */