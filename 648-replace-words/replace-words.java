class Solution {
    public String replaceWords(List<String> dic, String sen) {
        HashSet<String> st = new HashSet<>();

        for(String s : dic) st.add(s);
        
        StringBuilder ans = new StringBuilder();
       

        for(String s : sen.split(" ")){
            StringBuilder pre = new StringBuilder();
            char[]arr = s.toCharArray();

            for(int i=0; i<arr.length; i++){
                pre.append(arr[i]);
                if(st.contains(pre.toString()))break;
            }
            if(ans.length()>0) ans.append(" ");
            ans.append(pre);
        }

        return ans.toString();
    }
}