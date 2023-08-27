class Solution {
    public List<String> commonChars(String[] words) {

        int[] a = count(words[0]);

        for(int i=1; i<words.length; i++){

            int[]b = count(words[i]);

            for(int j=0; j<26; j++){
                a[j] = Math.min(a[j],b[j]);
            }
        }  

        ArrayList<String> ans = new ArrayList<>();

        for(int i=0; i<26; i++){
            char val = 'a';
            val += i;
            while(a[i]!=0){
                ans.add(val+"");
                a[i]--;
            }
        } 

        return ans;    
    }     
        
    public int[] count(String s){
        int[] t = new int[26];

        for(char c : s.toCharArray()) t[c-'a']++;

        return t;
    }
}