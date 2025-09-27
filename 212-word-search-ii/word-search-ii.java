class Solution {

    HashSet<Integer> st ;
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();

        for(int i=0; i<words.length; i++){
            makeTree(root, 0, i, words[i]);
        }

        st = new HashSet<>();
        boolean[][]visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++){

            for(int j=0; j<board[0].length; j++){

                travel(root, i, j, board, visited, words);
            }
        }

        List<String>ans = new LinkedList<>();

        for(int i : st) ans.add( words[i] );

        return ans;


    }

    public void travel(Node parent, int i, int j, char[][]board, boolean[][]visited, String[] words){

        if(i<0 || j<0 || i==board.length || j==board[0].length) return;

        if( visited[i][j] ) return;

        int val = board[i][j] - 'a';


        if(parent.children[val] == null ) return;

        visited[i][j] = true;

        Node curr = parent.children[val];

        if(curr.position != -1){
            st.add(curr.position);
        }

        travel(curr, i-1, j, board, visited, words);
        travel(curr, i, j+1, board, visited, words);
        travel(curr, i+1, j, board, visited, words);
        travel(curr, i, j-1, board, visited, words);

        visited[i][j] = false;



    }

    public void makeTree(Node parent, int idx, int position, String s){

        if(idx == s.length() ) return;

        int val = s.charAt(idx) - 'a';


        if(parent.children[val] == null){
            parent.children[val] = new Node();
        }

        Node child = parent.children[val];

        if(idx == s.length() - 1){
            child.position = position;
            
        }

        makeTree(child, idx+1, position, s);
    }

    public class Node{
        int position;
        Node[]children;

        Node(){
            position = -1;
            children = new Node[26];
        }
    }
}