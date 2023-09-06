class Solution {
    public int minSteps(String s, String t) {
        int [] arr = new int[26];

        for(char c : s.toCharArray()){
            arr[c - 'a'] ++;
        }

        for(char c : t.toCharArray()){
            arr[c - 'a'] --;
        }
        
        int count = 0;

        for(int i=0; i<26; i++){
            count += Math.abs(arr[i]);
        }

        return count;
    }
}