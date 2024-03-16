/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node ptr;
        Node temp;
        int n = 0;

        while(q.size()>0){
            n = q.size();
            
            ptr = q.remove();
            if(ptr.left != null) q.add(ptr.left);
            if(ptr.right != null) q.add(ptr.right);

            while(n-1>0){

                temp = q.remove();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                ptr.next = temp;
                ptr = temp;
                n--;            
                
            
            }


        }

        return root;
    }
}