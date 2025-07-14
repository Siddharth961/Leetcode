class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList();

        for(String s : strs){

            int i=0;

            for(List<String> arr : ans){
                // List<String> arr = ans.get(i);
                if( isAnagram(arr.get(0), s)){
                    arr.add(s);
                    break;
                }
                i++;

            }

            if(i == ans.size()){
                List<String> arr = new LinkedList();
                arr.add(s);
                ans.add(arr);
            }
        }

        return ans;
    }

    public boolean isAnagram(String s, String t) {
        int[]freq = new int[26];

        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<t.length(); i++){

            char c = t.charAt(i);

            if(freq[c - 'a'] == 0) return false;
            freq[c - 'a']--;
        }

        for(int i=0; i<26; i++) if(freq[i]>0) return false;

        return true;
    }

    
}