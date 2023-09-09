class Solution {
    public int firstUniqChar(String s) {
       int ans = s.length();

       for(char c='a'; c<='z'; c++ ){
           int idx = s.indexOf(c);
           if(idx!=-1 && idx==s.lastIndexOf(c)){
               if(ans>idx) ans=idx;
           }
       }

       if(ans==s.length()) return -1;
       else return ans;
    }
}