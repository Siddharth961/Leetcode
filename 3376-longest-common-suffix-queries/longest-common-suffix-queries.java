class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        Node root = new Node(' ');
        
        for(int i=0; i<wordsContainer.length; i++){
            String s = wordsContainer[i];
            make_tree(s.length() - 1, i, s, root);
        }

        int[]ans = new int[wordsQuery.length];
        int i=0;

        for(String s : wordsQuery){
            ans[i] = search(s.length() - 1, s, root);
            i++;
        }

        return ans;
    }

    public void make_tree(int idx, int idx_in_arr, String s, Node parent){

        if(parent.smallest_length > s.length()){
            parent.smallest_length = s.length();
            parent.el_idx = idx_in_arr;
        }

        if(idx < 0) return;

        int i = s.charAt(idx) - 'a';
        if(parent.child[i] == null) parent.child[i] = new Node(s.charAt(idx) );


        make_tree(idx - 1, idx_in_arr, s, parent.child[i]);


    }

    public int search(int idx, String s, Node parent){

        if(idx < 0 || parent.child[ s.charAt(idx) - 'a'] == null){
            return parent.el_idx;
        }

        return search(idx-1, s, parent.child[ s.charAt(idx) - 'a']);
    }

    public class Node{
        char val;
        int smallest_length;
        int el_idx;
        Node[]child;

        Node(char c){
            val = c;
            child = new Node[26];
            smallest_length = Integer.MAX_VALUE;
        }
    }
}