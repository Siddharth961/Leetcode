class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int a=0;
        int b=0;

        for(int i=0; i<word1.length(); i++){
            a = word1.charAt(i) - 'a';
            b = word2.charAt(i) - 'a';

            arr1[a]++;
            arr2[b]++;
        }

        int x=0;

        for(int i=0; i<26; i++){
            x = Math.abs(arr1[i]-arr2[i]);
            if(x>3) return false;
        }

        return true;
    }
}