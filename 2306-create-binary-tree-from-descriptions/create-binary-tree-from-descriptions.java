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
    public TreeNode createBinaryTree(int[][] descriptions) {
        
        HashMap<Integer, TreeNode> mp = new HashMap<>();

        HashSet<Integer> st = new HashSet<>();

        for(int[]arr : descriptions){

            int p = arr[0];
            int c = arr[1];

            st.add(c);


            if( !mp.containsKey(c) ){
                mp.put(c, new TreeNode(c) );
            }
            
            if( !mp.containsKey(p) ){
                mp.put(p, new TreeNode(p) );
            }

            TreeNode child = mp.get(c);
            TreeNode parent = mp.get(p);

            if(arr[2] == 1){
                parent.left = child;
            }
            else parent.right = child;

        }

        for(var k : mp.keySet()){

            if(st.contains(k) == false){
                return mp.get(k);
            }
        }


        return null;
    }
}