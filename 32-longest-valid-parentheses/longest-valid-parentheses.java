class Solution {
    public int longestValidParentheses(String s) {
            
        Stack<Integer>st = new Stack<>();

        char[]arr = s.toCharArray();
        int[]binary = new int[arr.length];        

        for(int i=0; i<arr.length; i++){

            if(arr[i]=='('){
                st.push(i);
            }
            else{
                if(st.size()==0){
                    binary[i] = 0;
                    
                }
                else{
                    binary[st.pop()] = 1;
                    
                    binary[i] = 1;
                    
                    
                }
               
            }
        }

        int count = 0;
        int max = 0;

        for(int i : binary){
            if( i == 0 ){
                max = Math.max( max, count);
                count = 0;
            }
            else count++;
        }
        max = Math.max( max, count);
        
        return max;
    }
}