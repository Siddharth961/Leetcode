class Solution {
    String[]arr = {"", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> al = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return al;
        StringBuilder sb = new StringBuilder();
        get_ans(0,digits,sb);
        return al;
    }

    public void get_ans(int idx, String digits, StringBuilder sb){

        if(idx >= digits.length()){
            al.add( sb.toString());
            return;
        }

        String s = arr[digits.charAt(idx) - '0' -1];
       

        for(char c : s.toCharArray()){
            sb.append(c);
            get_ans(idx+1, digits, sb);
            sb.deleteCharAt( sb.length()-1 );
        }
    }

}