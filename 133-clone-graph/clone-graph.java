/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> mp = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        return get_ans(node);
    }

    public Node get_ans(Node og_node){

        if(mp.containsKey(og_node.val)) return mp.get(og_node.val);
        
        Node my_node = new Node(og_node.val);

        mp.put(my_node.val, my_node);

        for(Node n : og_node.neighbors){
            my_node.neighbors.add( get_ans(n) );
        }

        return my_node;

    }
}