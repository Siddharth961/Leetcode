class Solution {

    public class Node{
        String val;
        TreeMap<String, Node> child = new TreeMap<>();

        Node(String c){
            val = c;
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {

        HashMap<String, LinkedList<Node> > mp = new HashMap();

        Node root = new Node("/");

        for(List<String> s : paths){
            make_trie(root, 0, s);
        }


        dfs_string(root, mp);

        for( var key : mp.keySet() ){
            // System.out.print(key + " - ");
            List<Node>e = mp.get(key);

            // for(Node n : e) System.out.print(n.val + " ");
            // System.out.println();
            if( e.size() > 1 && !key.equals("")){
                for( Node n : e){
                    n.val = "-";
                }
            }
        }

        // dfs_print(root);


        List<List<String>> ans = new LinkedList<>();
        dfs_ans(root, new LinkedList<>(), ans);


        return ans;
    }

    public void make_trie( Node root, int idx, List<String>s ){

        if(idx == s.size() ) return;
        String curr = s.get(idx);


        if( !root.child.containsKey(curr) ){
             root.child.put(curr ,new Node( curr ) );
        }

        make_trie( root.child.get(curr), idx+1, s);
    }

    public String dfs_string( Node root,  HashMap<String, LinkedList<Node> >mp ){
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();

        for(Node n : root.child.values()){
            sb.append( dfs_string(n , mp ) );
        }

        String str = sb.toString();

        if( !mp.containsKey(str)){

            mp.put(str, new LinkedList<>() );
            
        }

        mp.get(str).add( root );


        return root.val + str + " ";

    }

    public void dfs_ans( Node root, List<String> rsf, List<List<String>> ans){

        if(root == null || root.val.equals("-")) return;

        if(root.val.equals("/") == false){

            rsf.add(root.val);

            ans.add( new LinkedList<String>(rsf) );
        }

        for( Node n : root.child.values()){
            dfs_ans( n, rsf, ans);
        }

        if( rsf.size() > 0){
            rsf.remove( rsf.size() - 1);
        }
    }

    public void dfs_print(Node root){
        if(root == null) return;
        
        System.out.print(root.val + " ");

        boolean travel = false;

        for(Node n : root.child.values()){

            if(n != null) travel = true;

            dfs_print(n);

        }

        if( !travel ) System.out.println();
    }

}