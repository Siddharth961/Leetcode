class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[]alpha = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<String,Integer>mp = new HashMap<>();
        for(String s : words){
            String sb = "";
            for(int i=0; i<s.length(); i++){
                int x = s.charAt(i) - 97;
                sb += alpha[x];
            }
            mp.put(sb,1);
        }
        return mp.size();
    }
}