class Solution {
    public int minPartitions(String s) {
        char c = '0';

        for(int i=0; i<s.length(); i++){
            if(c<s.charAt(i)) c = s.charAt(i);
        }

        return (int)(c - '0');
    }
}