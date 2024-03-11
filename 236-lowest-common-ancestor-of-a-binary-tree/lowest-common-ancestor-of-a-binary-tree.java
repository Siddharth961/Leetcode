/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> al = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        get_path(root, p);
        List<TreeNode> p_list = al;
        al = new ArrayList<>();
        get_path(root, q);
        List<TreeNode> q_list = al;

        int i = 0;
        int j = 0;
        if(p_list.size() > q_list.size()) i = p_list.size() - q_list.size();
        if(p_list.size() < q_list.size()) j = q_list.size() - p_list.size();

        while( p_list.get(i) != q_list.get(j)){
            i++;
            j++;
        }
        return p_list.get(i);

    }

    public boolean get_path( TreeNode root, TreeNode tar){
        if(root == null) return false;
        if(root == tar){
            al.add(root);
            return true;
        }

        boolean a = get_path(root.left, tar);
        if(a==false) a = get_path(root.right, tar);

        if(a==true) al.add(root);
        return a;
    }
}