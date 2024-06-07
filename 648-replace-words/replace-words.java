class Solution {
    public String replaceWords(List<String> dic, String sen) {
        HashSet<String> st = new HashSet<>();

        for(String s : dic) st.add(s);
        
        StringBuilder ans = new StringBuilder();
       

        for(String s : sen.split(" ")){
            String pre = "";
            for(int i=1; i<=s.length(); i++){
                pre = s.substring(0,i);
                if(st.contains(pre))break;
            }
            if(ans.length()>0) ans.append(" ");
            ans.append(pre);
        }

        return ans.toString();
    }
}