class Solution {
    public boolean buddyStrings(String s, String goal) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = goal.toCharArray();

        if(arr1.length != arr2.length) return false;

        int[]freq_1 = new int[26];
        int[]freq_2 = new int[26];

        int count = 0;
        boolean dupli = false;

        char a=' ',b=' ',c=' ',d=' ';

        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]){
                count++;
                if(count>2) return false;
            }

            freq_1[ arr1[i] - 'a']++;
            freq_2[ arr2[i] - 'a']++;

            if(freq_1[ arr1[i]-'a'] >= 2) dupli = true;
        }

        for(int i=0; i<26; i++){
            if(freq_1[i] != freq_2[i]) return false;
        }

        if(count == 2 || (count==0 && dupli == true)) return true;
        return false; 


    }
}