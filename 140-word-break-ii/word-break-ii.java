class Solution {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {

        ans = new LinkedList<>();
        Node root = new Node();

        for(String word : wordDict) makeTrie(0, root, word);
                
        travel(0, root, root, s, new LinkedList<>());

        return ans;
    }

    public void travel(int idx, Node curr, Node root, String s, List<Integer>spaces){

        if(idx == s.length()){
            if(curr == root){
                ans.add( add_ans(spaces, s) );
                // System.out.println(spaces);
            }

            return ;
        }

        char c = s.charAt(idx);

        Node child = curr.children[c-'a'];

        if( child == null) return;

        if(child.end == true){
            spaces.add(idx);
            travel(idx+1, root, root, s, spaces);
            spaces.remove(spaces.size()  - 1);
        }
        travel(idx+1, child, root, s, spaces);

    }

    public String add_ans(List<Integer>spaces, String s){

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length() ; i++){

            sb.append( s.charAt(i) );

            if(i!=s.length()-1 && i == spaces.get(idx)){
                sb.append(' ');
                idx++;
            }

        }

        return sb.toString();
    }

    public void makeTrie(int idx, Node root, String s){
        if(idx == s.length() ) return;

        int val = s.charAt(idx) - 'a';

        if(root.children[val] == null ) root.children[val] = new Node();

        Node child = root.children[val];

        if(idx == s.length() - 1) child.end = true;

        makeTrie(idx+1, child, s);
    }

    public class Node{
        boolean end;
        Node[]children;

        Node(){
            end = false;
            children = new Node[26];
        }
    }
}