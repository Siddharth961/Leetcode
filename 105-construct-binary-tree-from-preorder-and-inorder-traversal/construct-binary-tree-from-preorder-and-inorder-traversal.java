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
    HashMap<Integer, Integer> mp ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mp = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            mp.put(inorder[i], i);
        }
        return get_ans(0, inorder.length-1, 0, preorder.length-1, preorder, inorder);
    }

    public TreeNode get_ans(int is, int ie, int ps, int pe, int[]preorder, int[]inorder){

        if(ie<is || pe<ps) return null;

        int val = preorder[ps];
        int root = mp.get(val);

        TreeNode temp = new TreeNode(val);

        

        int left_in = root-is;

        temp.left = get_ans(is, root-1, ps+1, ps+left_in, preorder, inorder);
        temp.right = get_ans(root+1, ie, ps+left_in+1, pe, preorder, inorder);

        return temp;


    }
}