class Node{
    char val;
    boolean end;
    Node[]child = new Node[26];
}
class WordDictionary {
    Node root;

    public WordDictionary() {
        root =  new Node();
    }
    
    public void addWord(String word) {
        addHelper(root, 0, word);
    }

    public void addHelper(Node parent, int idx, String s){
        if(idx == s.length()){
            parent.end = true;
            return;
        }

        char c = s.charAt(idx);

        if(parent.child[ c - 'a'] == null) parent.child[c - 'a'] = new Node();


        addHelper( parent.child[c-'a'], idx+1, s);
    }
    
    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }

    public boolean searchHelper(Node parent, int idx, String s){

        if(parent == null) return false;
        if(idx == s.length()){
            if(parent.end ) return true;
            return false;
        }


        char c = s.charAt(idx);

        boolean ans = false;

        if( c == '.'){
            for(Node n : parent.child){
                ans = ans || searchHelper(n, idx+1, s);
            }
        }

        else{
            ans = searchHelper( parent.child[c-'a'], idx+1, s);
        }

        return ans;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */