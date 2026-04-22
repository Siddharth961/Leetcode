class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        Node root = new Node(' ');

        for(String s : dictionary){
            populate(0, s, root);
        }

        List<String> ans = new LinkedList<>();

        for(String s : queries){

            if( search(0, 2, s, root) ) ans.add(s);
        }

        return ans;
    }

    public boolean search(int idx, int edits, String s, Node root){

        if(idx == s.length() ){
            // we have reached and found end element as well
            // need to make sure a word actually ends here as well

            return  root.end;
        }

        boolean ans = false;

        char c = s.charAt(idx);

        for(int i = 0; i<26; i++){

            if(root.arr[i] == null) continue;

            if(c == (char)('a' + i )){
                ans = ans || search(idx+1, edits, s, root.arr[i]);
            }
            else if(edits > 0){
                ans = ans || search(idx+1, edits-1, s, root.arr[i]);

            }

        }

        return ans;
    }

    public void populate(int idx, String s, Node root){

        if(idx == s.length() ){
           
            root.end = true;
            return;
        }

        int i = s.charAt(idx) - 'a';

        if(root.arr[i] == null) root.arr[i] = new Node((char)('a' + i));

        populate(idx+1, s, root.arr[i]);

    }

    public class Node{
        Node[]arr = new Node[26];
        boolean end = false;
        char curr;

        Node(char c){

            curr = c;

        }
        


    }
}