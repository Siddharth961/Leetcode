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
        Node level = root;
        Node curr;
        Node next_level;
        Node curr_child;
        Node next_child;
        boolean shifted = false;

        while(level!=null){
            curr = level;
            shifted = false;
            next_level = null;

            while(curr!=null){
                if(next_level==null){
                    next_level = curr.left!=null ? curr.left : curr.right;
                }

                if(curr.left!=null){
                    curr.left.next = curr.right;
                }
                

                if(curr.left!=null || curr.right != null ){
                    curr_child = curr.right!=null ? curr.right : curr.left;
                    
                    curr = curr.next;
                    while(curr!=null && (curr.left==null && curr.right==null)){
                        curr = curr.next;
                    }
                    
                    shifted = true;

                    if(curr!=null){
                        next_child = curr.left!=null ? curr.left : curr.right;
                        curr_child.next = next_child;
                    }
                    
                }

                if(curr!=null && shifted==false)curr = curr.next;
            }
            level = next_level;
        }

        return root;
    }
}