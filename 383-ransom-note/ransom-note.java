class Solution {
    public boolean canConstruct(String ran, String mag) {
        int[]arr = new int[26];

        for(char c : mag.toCharArray()) arr[c-'a']++;

        for(char c : ran.toCharArray()){
            if(arr[c-'a']==0) return false;
            arr[c-'a']--;
        }

        return true;

    }
}