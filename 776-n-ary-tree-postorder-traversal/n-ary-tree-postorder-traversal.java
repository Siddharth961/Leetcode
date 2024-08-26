/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer>al;
    public List<Integer> postorder(Node root) {
        al = new ArrayList<>();
        get_ans(root);
        return al;
    }

    public void get_ans(Node root){
        if(root == null) return ;
        for(Node n : root.children) get_ans(n);
        al.add(root.val);
    }
}