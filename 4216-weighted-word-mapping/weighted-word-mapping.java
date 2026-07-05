class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        
        StringBuilder sb = new StringBuilder();

        for(String s : words){
            int val = 0;

            for(int i=0; i<s.length(); i++){
                val += weights[ s.charAt(i) - 'a' ];
            }

            val %= 26;

            sb.append( (char)('z' - val));
        }

        return sb.toString();
    }
}