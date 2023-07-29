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
        while(st.size()!=0){
            ans.insert(0,st.pop());
        }
        return ans.toString();
    }
}