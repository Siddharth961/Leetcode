class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[]arr = new int[26];

        Arrays.fill(arr,-1);
        int idx=0;
        char c=' ';

        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            idx = c - 'a';

            if(arr[idx]==-1) arr[idx]=i;
            else arr[idx] = i - arr[idx] - 1 ;            
        }
        for(int i=0; i<26; i++){
            if(arr[i]!=-1 && arr[i]!=distance[i]) return false;
        }


        return true;
    }
}