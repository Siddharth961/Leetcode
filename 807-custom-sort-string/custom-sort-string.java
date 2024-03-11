class Solution {
    public String customSortString(String order, String s) {
        int[]arr = new int[26];
        for(char c : s.toCharArray()) arr[c-'a']++;

        StringBuilder sb = new StringBuilder();

        for(char c : order.toCharArray()){
            while(arr[c-'a']>0){
                sb.append(c);
                arr[c-'a']--;
            }
        }

        for(int i=0; i<26; i++){
            while(arr[i]>0){
                sb.append((char)(i+97));
                arr[i]--;
            }

        }

        return sb.toString();
    }
}