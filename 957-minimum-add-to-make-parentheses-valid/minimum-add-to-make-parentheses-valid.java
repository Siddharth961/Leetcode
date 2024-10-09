class Solution {
    public int minAddToMakeValid(String s) {
        
        char[]arr = s.toCharArray();

        int open = 0;
        int ans = 0;

        for( char c : arr){
            if( c == '(') open++;
            else{
                if(open > 0)open--;
                else ans++;
            }
        }


        return ans + open;
    }
}