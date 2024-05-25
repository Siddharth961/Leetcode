class Solution {
    List<String>ans = new ArrayList<>();
    List<String> asf = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> st = new HashSet<>(wordDict);

        get_ans(0, 0, s, st);
        return ans;

    }

    public void get_ans(int idx, int left, String s,  HashSet<String>st){

        if(idx == s.length()){

            if(left==idx){
                
                make_ans();
            }
            return;
        }

        String ssf = s.substring(left, idx+1);
        
        
        if(st.contains( ssf )){

            asf.add(ssf);
            
            get_ans(idx+1, idx+1, s, st);

            asf.remove( asf.size()-1);
        }

        get_ans(idx+1, left, s, st);
    }

    public void make_ans(){

        if(asf.size()==0) return;

        StringBuilder sb = new StringBuilder();

        for(String s : asf){
            sb.append(s);
            sb.append(' ');
        }

        sb.deleteCharAt( sb.length()-1 );

        ans.add( sb.toString() );
    }
}