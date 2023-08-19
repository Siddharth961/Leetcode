class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[]alpha = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


        HashMap<String,Boolean>mp = new HashMap<>();
        for(String s : words){
            StringBuilder sb = new StringBuilder();
            for(char i: s.toCharArray()){
                int x = i - 97;
                sb.append(alpha[x]);
            }
            mp.put(sb.toString(),true);
        }
        return mp.size();
    }
}