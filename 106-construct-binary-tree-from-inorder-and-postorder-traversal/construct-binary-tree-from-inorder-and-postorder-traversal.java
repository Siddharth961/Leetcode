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
    HashMap<Integer, Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++) mp.put(inorder[i], i);

        return get_ans(0, inorder.length-1, 0, postorder.length-1, inorder, postorder);
    }
    public TreeNode get_ans(int is, int ie, int ps, int pe, int[]inorder, int[]postorder){
        if(ie<is || pe<ps) return null;

        int in_val = mp.get( postorder[pe] );
        int left_size = in_val - is;

        TreeNode temp = new TreeNode(postorder[pe]);

        temp.left = get_ans(is, in_val-1, ps, ps+ left_size-1, inorder, postorder);
        temp.right = get_ans(in_val+1, ie, ps+left_size, pe-1, inorder, postorder);

        return temp;
    }
}