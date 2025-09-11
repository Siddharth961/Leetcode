class Solution {
     List<String> ans = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        
        get_ans( new StringBuilder(), 0, 0, n);

        return ans;
    }

    public void get_ans(StringBuilder sb, int open, int close, int n){

        if(open == n && close == n){
            ans.add(sb.toString());

            return;
        }

        if( open < n){
            sb.append('(');

            get_ans(sb, open+1, close, n);

            sb.deleteCharAt( sb.length() - 1);
        }
        if( open > close){
            sb.append(')');

            get_ans(sb, open, close + 1, n);

            sb.deleteCharAt( sb.length() - 1);
        }
    }
}