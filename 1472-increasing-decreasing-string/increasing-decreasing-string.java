class Solution {
    public String sortString(String s) {
        int[]arr = new int[26];

        for(char c : s.toCharArray()){
            arr[c-'a']++;
            
        }       

      
        StringBuilder ans = new StringBuilder();       

        while(ans.length()!=s.length()){

            for(int i=0; i<arr.length; i++){
                if(arr[i]==0) continue;
                ans.append((char)(i+'a'));
                arr[i]--;

            }
            for(int i=arr.length-1; i>=0; i--){
                if(arr[i]==0) continue;
                ans.append((char)(i+'a'));
                arr[i]--;

            }
        }
        return ans.toString();
    }
}