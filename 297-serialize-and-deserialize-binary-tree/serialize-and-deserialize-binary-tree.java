/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        get_string(root, sb);
        sb.deleteCharAt(sb.length()-1);
        // System.out.println(sb);
        return sb.toString();
        
    }

    public void get_string(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("n,");
            return ;
        }

        sb.append(root.val);
        sb.append(',');

        get_string(root.left, sb);
        get_string(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]arr = data.split(",");
        // for(String c : arr) System.out.print(c + " ");

        return get_tree(arr);
    }

    int idx = 0;

    public TreeNode get_tree( String[]arr){
        if(arr[idx].equals("n")){
            // idx++;
            return null;
        }

        TreeNode root = new TreeNode( Integer.parseInt(arr[idx]) );
        idx++;        
        root.left = get_tree(arr);
        idx++;
        root.right = get_tree(arr);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));