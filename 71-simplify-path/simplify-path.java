class Solution {
    public String simplifyPath(String path) {
        
        String[]arr = path.split("/");

        Stack<String> st = new Stack<>();

        for(String s : arr){

            if(s.length() == 0 || s.equals(".")) continue;

            else if(s.equals("..") ){ if( st.size() > 0) st.pop();}

            else st.push(s);

        }

        StringBuilder sb = new StringBuilder();

        for(String s : st){
            sb.append("/");
            sb.append(s);
        }

        if(sb.length() == 0) return "/";
        return sb.toString();
    }
}