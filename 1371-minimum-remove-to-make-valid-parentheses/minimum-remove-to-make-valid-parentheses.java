class Solution {
    public String minRemoveToMakeValid(String s) {
        
        char[]arr = s.toCharArray();
        int open=0;

        char c = ' ';

        for(int i=0; i<arr.length; i++){
            c = arr[i];
            if(c=='(') open++;
            else if(c==')'){
                if(open==0) arr[i] = '*';
                else open--;
            }
        }

        int close = 0;

        for(int i=arr.length-1; i>=0; i--){
            c = arr[i];
            if(c==')') close++;
            else if(c=='('){
                if(close==0) arr[i] = '*';
                else close--;
            }
        }

        StringBuilder sb = new StringBuilder();

        for( var e : arr){
            if(e!='*') sb.append(e);
        }

        return sb.toString();
    }
}