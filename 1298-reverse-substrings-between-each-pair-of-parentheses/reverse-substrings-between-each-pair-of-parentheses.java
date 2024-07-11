class Solution {
    public String reverseParentheses(String s) {
        char[]arr = s.toCharArray();

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i]=='(') st.push(i);
            else if(arr[i]==')') reverse(arr, st.pop(), i);
        }

        StringBuilder sb = new StringBuilder();

        for(char c : arr){
            if(c != ')' && c!='(') sb.append(c);
        }

        return sb.toString();
    }

    public void reverse (char[]arr, int i, int j){

        char t = ' ';

        while(i<=j){
            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;

            i++;
            j--;
        }

    }
}