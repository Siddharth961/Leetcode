class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] arr = new int[26];
        int a=0;
        int b=0;

        for(int i=0; i<word1.length(); i++){
            a = word1.charAt(i) - 'a';
            b = word2.charAt(i) - 'a';

            arr[a]++;
            arr[b]--;
        }

        for(int i=0; i<26; i++){
            if(arr[i]>3 || arr[i]<-3) return false;
        }

        return true;
    }
}