class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        char[]arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
         
            if(st.size()!=0 && st.peek()==c) st.pop();
            else st.push(c);
        }
        StringBuilder ans = new StringBuilder();
        for(char ch : st){
        ans.append(ch);
        }
        return ans.toString();
    }
}