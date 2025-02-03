class Solution {
    public String findValidPair(String s) {
        
        int[]freq = new int[9];

        char[]arr = s.toCharArray();

        for(char c : arr) freq[ c - '1']++;

        for(int i=1; i<arr.length; i++){
            int a = (int)(arr[i-1] - '1');
            int b = (int)(arr[i] - '1');

            if( a!=b && freq[a] == a+1 && freq[b] == b+1){
                return s.substring(i-1, i+1);
            }
        }

        return "";
    }
}