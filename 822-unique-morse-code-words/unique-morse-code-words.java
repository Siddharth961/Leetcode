class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[]alpha = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


        HashMap<String,Boolean>mp = new HashMap<>();
        for(String s : words){
            StringBuilder sb = new StringBuilder();
            for(char i: s.toCharArray()){
                
                sb.append(alpha[i - 97]);
            }
            mp.put(sb.toString(),true);
        }
        return mp.size();
    }
}