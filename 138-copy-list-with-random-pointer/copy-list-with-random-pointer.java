/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> lookup;

    public Node copyRandomList(Node head) {

        lookup = new HashMap<>();

        Node n_head = makeList(head);

        populate_random(head);

        return n_head;
        
    }

    public Node makeList(Node head){
        if(head == null) return null;

        Node new_node = new Node(head.val);

        lookup.put(head, new_node);

        new_node.next = makeList(head.next);

        return new_node;
    }

    public void populate_random(Node head){

        if(head == null) return;

        Node curr = lookup.get(head);

        if(head.random != null)curr.random = lookup.get( head.random );

        populate_random(head.next);
    }

}