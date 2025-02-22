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
    public TreeNode recoverFromPreorder(String traversal) {
        return get_ans(new int[1], 0, traversal);
    }

    public TreeNode get_ans(int[]idx, int level, String s){

        int n = get_num(idx, s);


        TreeNode root = new TreeNode( n );

        int i = idx[0];

        i++;
        int next_level = 0;

        while( i<s.length() && s.charAt(i) == '-'){
            next_level++;
            i++;
        }

        // if(n == 401) System.out.println(idx[0]+" "+level+" " + next_level);
        if(next_level == level + 1){
            idx[0] = i;
            root.left = get_ans(idx, next_level, s);
        }
        else return root;

        i = idx[0];
        i++;
        next_level = 0;

        while(i<s.length() && s.charAt(i) == '-'){
            next_level++;
            i++;
        }

        if(next_level == level + 1){
            idx[0] = i;
            root.right = get_ans(idx, next_level, s);
        }

        return root;

    }

    public int get_num(int[]idx, String s){
        int n = 0;

        while(idx[0]<s.length() && s.charAt(idx[0]) >= '0' && s.charAt(idx[0])<='9'){
            n = n*10 + ( (int)(s.charAt(idx[0]) - '0') );
            idx[0]++;
        }

        idx[0]--;

        return n;
    }
}