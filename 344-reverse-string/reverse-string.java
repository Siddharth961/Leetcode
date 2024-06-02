class Solution {
    public void reverseString(char[] s) {
        
        int i=0;
        int j=s.length-1;

        while(i<j){
            char t = s[j];
            s[j] = s[i];
            s[i] = t;

            i++;
            j--;
        }
    }
}